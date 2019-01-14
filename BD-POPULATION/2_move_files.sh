#!/bin/bash
if [ "$EUID" -ne 0 ]
  then echo '!!!ENTER ROOT PASSWORD AND RE-LAUNCH THIS AS ROOT!!!'
  su
  exit
fi
cp /var/lib/mysql-files/*.csv /var/lib/neo4j/import/
