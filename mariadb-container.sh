docker run --name mariadb -d -p3306:3306 \
  --restart=always \
  -e MARIADB_ROOT_PASSWORD=RootPassword \
  -e MARIADB_DATABASE=iot-server \
  -e MARIADB_USER=iot-server \
  -e MARIADB_PASSWORD=iot-server-password \
  docker-proxy.cloud.ga66a.ru/mariadb:10.9.4