from centos:centos7.9.2009
maintainer afcfzf <9301462@qq.com>
label version="1.0"
label description="docker for redis"

RUN mkdir -p /data/software/

RUN ["chmod", "777", "/data/software/"]

WORKDIR /data/software/

COPY ./assets/* ./

RUN sh ./init.sh

