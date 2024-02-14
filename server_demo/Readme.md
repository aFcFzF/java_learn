## 部署
``` bash
docker build -t swr.cn-north-4.myhuaweicloud.com/mark-dev/server-demo:v0.0.1 ./
docker push swr.cn-north-4.myhuaweicloud.com/mark-dev/swr-demo-2048:latest
```
## 删除
``` bash
docker rmi -f $(docker images 'swr.cn-north-4.myhuaweicloud.com/mark-dev/server-demo' -a -q)
```

## 环境变量
``` bash
-D SPRING_PROFILES_ACTIVE
```