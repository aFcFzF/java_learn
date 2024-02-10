#!/bin/bash

DOCKER_NAME=swr.cn-north-4.myhuaweicloud.com/mark-dev/server-demo;
DOCKER_VERSION="$(git rev-parse --short HEAD)";
DOCKER_NAME_WITH_VER=$DOCKER_NAME:$DOCKER_VERSION;
DOCKER_NAME_WITH_LATEST=$DOCKER_NAME:latest;

docker build -t "$DOCKER_NAME_WITH_VER" ./;
docker tag "$DOCKER_NAME_WITH_VER" $DOCKER_NAME_WITH_LATEST;

docker push $DOCKER_NAME_WITH_LATEST;
