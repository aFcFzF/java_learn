from centos:centos7.9.2009
maintainer afcfzf <9301462@qq.com>
label version="1.0"
label description="docker for java base"

RUN mkdir -p /data/software/
WORKDIR /data/software/

COPY ./assets/* ./

RUN sh ./init.sh

ENV JAVA_HOME /data/software/TencentKona-17.0.10.b1
ENV PATH ${JAVA_HOME}/bin:$PATH
