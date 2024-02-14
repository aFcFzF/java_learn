#!/usr/bin/bash

tar -zxf ./TencentKona-17.0.10.b1-jdk_linux-x86_64.tar.gz

## declare an array variable
declare -a arr=("/root/.bashrc" "/bin/profile")

## now loop through the above array
for i in "${arr[@]}"
do
  echo "$i"
  BASHRC_PATH="$i"
  echo "export JAVA_HOME=/data/software/TencentKona-17.0.10.b1;" >>$BASHRC_PATH
  source $BASHRC_PATH
  echo "export PATH=$JAVA_HOME/bin:$PATH;" >>$BASHRC_PATH
  source $BASHRC_PATH
done