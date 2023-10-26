#!/bin/bash
TIMESTAMP=`date '+%Y%m%d%H%M%S'`
echo "Building image: books-database:0.0.1-${TIMESTAMP}"
docker build -t books-database:0.0.1-${TIMESTAMP} .
