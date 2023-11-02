#!/bin/bash
echo "Stopping container: books-database ..."
docker stop books-database
echo "Removing container: books-database ..."
docker rm books-database
echo "Running image: books-database ..."
docker run --name books-database --publish 3306:3306 --detach books-database:0.0.1-20231101060505
echo "Waiting for 5 secs ..."
sleep 5
echo "Please check if the container is running using this command:"
echo "    docker ps --filter name=books-database"
echo "In case if you want to access the database, use below commands:"
echo "    docker exec -it books-database /bin/bash"
echo "    mysql -u service -ppassword books"
