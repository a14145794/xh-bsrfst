#!/bin/bash

#主机(宿主)端口
inPort='8199'
#容器端口
outPort='8199'
#生成的镜像名
image='xh-bsrfst'
#需要改名的jar包名称
jarName='xh-bsrfst'
#自动识别日期
tm=`date +%m`
td=`date +%d`
bkfile=$jarName.$tm$td
savedBkFile=$bkfile


#开始
echo "删除老镜像 docker rm ... \n"
docker rm -f ${image}
docker rmi -f ${image}
#执行docker构建
echo "docker build -t"
docker build -t ${image} .
sleep 5s

#对jar包进行更名备份
echo "back file success..."
i=0
while [ -f $savedBkFile ]
do
      let i++
      savedBkFile=$bkfile$i
done
mv ${jarName}.jar $savedBkFile

#打包容器启动
echo "docker run"
#宿主机模式 无视port端口映射
#docker run  -d --restart=always --net=host --name ${image}  ${image}
docker run  -d --restart=always  --name ${image} -p ${inPort}:${outPort}  ${image}
echo "success start ...\n";
sleep 1s
#输出日志
docker logs -f ${image}

