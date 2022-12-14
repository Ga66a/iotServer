FROM docker-proxy.cloud.ga66a.ru/openjdk:17-alpine
RUN apk add curl
WORKDIR "/app"
EXPOSE 8080
COPY ./build/libs/iotServer-0.0.1-SNAPSHOT.jar /app/app.jar
HEALTHCHECK --interval=5s --timeout=10s --retries=3 CMD curl -sS 127.0.0.1:8080/actuator/health/ || exit 1
CMD java -jar app.jar