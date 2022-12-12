Start mysql:

docker run --name mariadb -d -p3306:3306 \
  --restart=always \
  -v /data/docker/volumes/mariadb:/var/lib/mysql \
  -e MARIADB_ROOT_PASSWORD=<ROOT_PASSWORD> \
  -e MARIADB_DATABASE=iot-server \
  -e MARIADB_USER=<USERNAME> \
  -e MARIADB_PASSWORD=<PASSWORD> \
  docker-proxy.cloud.ga66a.ru/mariadb:10.9.4

Start server:

docker run --name=iot-server -p 8085:8080 -d --restart always \
  -e MYSQL_HOST=localhost \
  -e MYSQL_PASSWORD=<PASSWORD> \
  -e MYSQL_USER=<USERNAME> \
  docker.cloud.ga66a.ru/iot-server:v0.0.1
