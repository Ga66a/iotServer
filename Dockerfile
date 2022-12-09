FROM docker-proxy.cloud.ga66a.ru/openjdk:17-alpine
HEALTHCHECK CMD curl --fail http://localhost:8080 || exit 1
WORKDIR "/app"
EXPOSE 8080
COPY ./build/libs/iotServer-0.0.1-SNAPSHOT.jar /app/app.jar
CMD java -jar app.jar