Start mariaDB:
docker run --name mariadb -d -p3306:3306 \
  --restart=always \
  -v /data/docker/volumes/mariadb:/var/lib/mysql \
  -e MARIADB_ROOT_PASSWORD=<ROOT_PASSWORD> \
  -e MARIADB_DATABASE=iot-server \
  -e MARIADB_USER=<USERNAME> \
  -e MARIADB_PASSWORD=<PASSWORD> \
  docker-proxy.cloud.ga66a.ru/mariadb:10.9.4
 
Start victoria metrics
docker run -d --name victoriaMetrics \
  --restart always \
  -v /path/to/victoria-metrics-data:/victoria-metrics-data \
  -p 8428:8428 \
  -p 4242:4242 \
  docker-proxy.cloud.ga66a.ru/victoriametrics/victoria-metrics:v1.85.1 --opentsdbListenAddr=0.0.0.0:4242

#  --entrypoint="/victoria-metrics-prod -httpAuth.username=test -httpAuth.password=123"

Start grafana
docker run  -d --name=grafana \
  --restart always \
  -p 3100:3000 \
  -v /path/to/grafana-data:/var/lib/grafana
  docker.cloud.ga66a.ru/grafana/grafana:9.3.2

Start server:
docker run --name=iot-server -p 8085:8080 -d --restart always \
  -e MARIADB_HOST=<DBHostname> \
  -e MARIADB_PASSWORD=<PASSWORD> \
  -e MARIADB_USER=<USERNAME> \
  -e OPENTSDB_HOST=http://10.10.10.10:4242 \
  -e OPENTSDB_APIPATH=/api \
  docker-proxy.cloud.ga66a.ru/iot-server:v0.0.1
