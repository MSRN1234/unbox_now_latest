#!/bin/bash

cd /home/ubuntu/unbox-cicd
check=$(pm2 list | grep unbox-api | grep stopped | awk '{print $18}')

if [ "$check" = "stopped" ]; then
  echo "pm2 is stopped"
  echo "starting pm2 service..."
  pm2 start unbox-run.sh --name unbox-api --time
elif [ -z "$check" ]
then
   pm2 start unbox-run.sh --name unbox-api --time
fi
