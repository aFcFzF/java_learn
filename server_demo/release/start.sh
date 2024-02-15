#!/usr/bin/bash

cat ~/.bashrc
java -version
# source ~/.bashrc
java -jar -Dspring.profiles.active=prod ./demo-1.0.jar || true
