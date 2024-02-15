#!/usr/bin/bash

cat ~/.bashrc
source ~/.bashrc
java -jar -Dspring.profiles.active=prod ./demo-1.0.jar || true
