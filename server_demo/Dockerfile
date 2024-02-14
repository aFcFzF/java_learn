from swr.cn-north-4.myhuaweicloud.com/mark-dev/java_docker_base:v0.0.1
maintainer afcfzf <9301462@qq.com>
label version="1.0"
label description="docker for java server"
expose 8080

run mkdir -p /work/proj/demo
workdir /work/proj/demo

copy ./target/demo-1.0.jar ./
copy ./release/start.sh ./

RUN ["chmod", "+x", "./start.sh"]
ENTRYPOINT ["./start.sh"]
