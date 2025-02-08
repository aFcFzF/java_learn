## 部署
``` bash
docker build -t swr.cn-north-4.myhuaweicloud.com/mark-app/server-mini:v0.0.1 ./
docker push swr.cn-north-4.myhuaweicloud.com/mark-app/server-mini:latest
```
## 删除
``` bash
docker rmi -f $(docker images 'swr.cn-north-4.myhuaweicloud.com/mark-app/server-mini' -a -q)
```

## 环境变量
``` bash
-D SPRING_PROFILES_ACTIVE
```

## vscode测试
``` json
"java.debug.settings.vmArgs": "-Djasypt.encryptor.password=",
"java.test.config": {
  "vmArgs": ["-Djasypt.encryptor.password="]
}
```