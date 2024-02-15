#!/usr/bin/bash

cat ~/.bashrc

java -jar -Dspring.profiles.active=prod ./demo-1.0.jar || true
