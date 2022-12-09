FROM docker-proxy.cloud.ga66a.ru/openjdk:17-alpine
#RUN "mkdir /sgm"
COPY ./build/libs/iotServer-0.0.1-SNAPSHOT.jar /app/app.jar
HEALTHCHECK CMD curl --fail http://localhost:8080 || exit 1
WORKDIR "/app"
EXPOSE 8080
CMD java -jar app.jar