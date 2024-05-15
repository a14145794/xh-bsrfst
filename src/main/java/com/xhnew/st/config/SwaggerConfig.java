package com.xhnew.st.config;

import cn.hutool.extra.spring.SpringUtil;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import com.xhnew.st.config.properties.SwaggerProperties;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Swagger 文档配置
 *
 * @author Lion Li
 */
@RequiredArgsConstructor
@Configuration
@EnableKnife4j
public class SwaggerConfig  {

    private final SwaggerProperties swaggerProperties;
    private final OpenApiExtensionResolver openApiExtensionResolver;

    /**
     * 用于适配springboot 2.6
     */
    @Bean
    @SuppressWarnings("all")
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
                mappings.removeIf(mapping -> mapping.getPatternParser() != null);
            }

            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    field.setAccessible(true);
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }

    /**
     * 创建API
     */
    @PostConstruct
    public void createRestApi() {
        for (SwaggerProperties.Groups group : swaggerProperties.getGroups()) {
            String basePackage = group.getBasePackage();
            Docket docket = new Docket(DocumentationType.OAS_30)
                    .enable(swaggerProperties.getEnabled())
                    // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                    .apiInfo(apiInfo())
                    // 设置哪些接口暴露给Swagger展示
                    .select()
                    // 扫描所有有注解的api，用这种方式更灵活
                    //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                    // 扫描指定包中的swagger注解
                    .apis(RequestHandlerSelectors.basePackage(basePackage))
                    // 扫描所有 .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build()
                    .groupName(group.getName())
                    // 设置安全模式，swagger可以设置访问token
                    .securityContexts(securityContexts())
                    .extensions(openApiExtensionResolver.buildExtensions(group.getName()))
                    .pathMapping(swaggerProperties.getPathMapping());
            String beanName = StringUtils.substringAfterLast(basePackage, ".") + "Docket";
            SpringUtil.registerBean(beanName, docket);
        }
    }


    /**
     * 安全上下文
     */
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                        .build());
        return securityContexts;
    }



    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        SwaggerProperties.Contact contact = swaggerProperties.getContact();
        return new ApiInfoBuilder()
                // 设置标题
                .title(swaggerProperties.getTitle())
                // 描述
                .description(swaggerProperties.getDescription())
                // 作者信息
                .contact(new Contact(contact.getName(), contact.getUrl(), contact.getEmail()))
                // 版本
                .version(swaggerProperties.getVersion())
                .build();
    }
}
