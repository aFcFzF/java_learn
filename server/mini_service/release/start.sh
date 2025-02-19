#!/usr/bin/bash

cat ~/.bashrc
java -version
# source ~/.bashrc
java -jar -Dspring.profiles.active=prod ./mini_service-1.0.jar || true
