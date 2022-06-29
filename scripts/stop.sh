#!/bin/bash

check=$(pm2 list | grep unbox-api | grep online | awk '{print $18}')

if [ "$check" = "online" ]; then
  echo "pm2 is online"
  echo "stop pm2 service..."
  pm2 stop unbox-api
fi
