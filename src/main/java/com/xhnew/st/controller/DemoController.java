package com.xhnew.st.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileReader;
import com.xhnew.st.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 地址简介Controller
 *
 * @author mashiro
 * @date 2022-03-21
 */
@Validated
@Api(value = "测试", tags = {"测试"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {

    public static String getPath(String subdirectory) {
        //获取跟目录---与jar包同级目录的upload目录下指定的子目录subdirectory
        File upload = null;
        try {
            //本地测试时获取到的是"工程目录/target/upload/subdirectory
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            upload = new File(path.getAbsolutePath(), subdirectory);
            if (!upload.exists()) {
                upload.mkdirs();//如果不存在则创建目录
            }
            String realPath = upload + "/";
            return realPath;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("获取服务器路径发生错误！");
        }
    }

    /**
     * 读取JSON文件转换为字符串
     *
     * @param filePath
     * @return
     */
    public static String readJsonFile(String filePath) {
        String jsonStr = "";
        try {
            File jsonFile = new File(filePath);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static final String TEMP = "temp";
    public static final String BASE_PATH = "/json";

    @ApiOperation("获取beishanJson")
    @GetMapping("/getBeishanJson")
    public String getBeishanJson() {
        return getJson("beishan.json");
    }

    @ApiOperation("获取xixiJson")
    @GetMapping("/getxixiJson")
    public String getxixiJson() {
        return getJson("xixi.json");
    }

    @ApiOperation("获取jiangcunJson")
    @GetMapping("/getJiangcunJson")
    public String getJiangcunJson() {
        return getJson("jiangcun.json");
    }

    @ApiOperation("根据名称获取json文件")
    @GetMapping("/getJsonFromFileName")
    public String getJsonFromFileName(@NotNull(message = "文件名不能为空") String fileName) {
        return getJson(fileName + ".json");
    }

    private String getJson(String beishanJson) {
        String jsonPath = getPath(TEMP);
        InputStream inputStream = this.getClass().getResourceAsStream(BASE_PATH + File.separator + beishanJson);
        try {
            IoUtil.copy(inputStream, new FileOutputStream(jsonPath + File.separator + beishanJson));
        } catch (Exception e) {
            e.printStackTrace();
        }

        cn.hutool.core.io.file.FileReader fileReader = new FileReader(jsonPath + File.separator + beishanJson);
        String result = fileReader.readString();
        return result;
    }

}
