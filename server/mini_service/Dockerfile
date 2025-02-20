from swr.cn-north-4.myhuaweicloud.com/mark-app/java_docker_base:v0.0.3
maintainer afcfzf <9301462@qq.com>
label version="1.0"
label description="docker for java server"
expose 8080

run mkdir -p /work/proj/mini
workdir /work/proj/mini

copy ./build/libs/mini_service.jar ./
copy ./release/start.sh ./

RUN ["chmod", "777", "./start.sh"]

USER root

ENTRYPOINT ["./start.sh"]
