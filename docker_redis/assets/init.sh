#!/bin/bash

if [ -z "$(ls -A /data/config/mysql/db)" ]; then
  /etc/init.d/mariadb setup
  echo "mysql initialed"
fi

rc-service mariadb start

if [[ $1 == "-d" ]]; then
  while true; do sleep 1000; done
fi

if [[ $1 == "-bash" ]]; then
  /bin/bash
fi

echo "check: $1"
