#!/bin/bash
echo "Stopping container: books-service ..."
docker stop books-service
echo "Removing container: books-service ..."
docker rm books-service
echo "Running image: books-service ..."
docker run --name books-service --publish 8080:8080 --detach ghcr.io/weijuly/books-service:0.0.1-SNAPSHOT-20231101005246
echo "Waiting for 5 secs ..."
sleep 5
echo "Please check if the container is running using this command:"
echo "    docker ps --filter name=books-service"
