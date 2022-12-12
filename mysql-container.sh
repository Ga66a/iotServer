docker run --name mysql -d -p3306:3306 \
  --restart=always \
  -e MYSQL_ROOT_PASSWORD=RootPassword \
  -e MYSQL_DATABASE=iot-server \
  -e MYSQL_USER=iot-server \
  -e MYSQL_PASSWORD=iot-server-password \
  docker-proxy.cloud.ga66a.ru/mysql:8.0.31