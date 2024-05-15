FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER Mashiro
ADD xh-bsrfst.jar app.jar
# 指定于外界交互的端口
EXPOSE 9411
VOLUME /tmp
#改变时区
#RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
ENTRYPOINT ["java", "-jar","./app.jar", "--spring.profiles.active=prod"]
