#!/bin/bash

if [ -z "$(ls -A /data/config/mysql/db)" ]; then
  /etc/init.d/mariadb setup
  mysql_install_db
  echo "mysql initialed"
fi

# 启动mysql
rc-service mariadb start

# 启动redis
redis-server /data/config/redis/redis.conf --appendonly yes

if [[ $1 == "-d" ]]; then
  while true; do sleep 1000; done
fi

if [[ $1 == "-bash" ]]; then
  /bin/bash
fi

echo "check: $1"
