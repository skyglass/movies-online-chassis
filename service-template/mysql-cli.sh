#! /bin/bash -e

docker run ${1:--it} \
   --name mysqlterm --network=${PWD##*/}_default --rm \
   -e MYSQL_HOST=mysql \
   mysql:8.0.27 \
   sh -c 'exec mysql -h"$MYSQL_HOST"  -uroot -prootpassword -o eventuate'
