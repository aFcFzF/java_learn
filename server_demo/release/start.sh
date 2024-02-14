#!/usr/bin/bash

cat ~/.bashrc

echo "--------"
whoami
echo "--------"

source ~/.bashrc
java -jar ./demo-1.0.jar || true;
