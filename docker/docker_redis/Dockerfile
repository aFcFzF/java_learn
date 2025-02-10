from redis:7.2.4-alpine
maintainer afcfzf <9301462@qq.com>
label version="1.0"
label description="docker for redis"

RUN mkdir -p /data/software/

RUN apk update --no-check-certificate && apk add --no-check-certificate bash curl

RUN apk add --no-check-certificate --no-cache mysql mysql-client openrc \
&& rc-update add mariadb default \
&& openrc && touch /run/openrc/softlevel

WORKDIR /data/software/

COPY ./assets/* ./

RUN ["chmod", "777", "-R",  "/data/software/"]

CMD ["sh", "-c", "./init.sh -d"]

ENTRYPOINT [ "3306" ]
