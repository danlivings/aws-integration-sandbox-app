FROM openjdk:8-jdk-alpine

COPY . /app
WORKDIR /app

RUN ./gradlew build -x test

EXPOSE 8080

HEALTHCHECK CMD curl --fail --silent localhost:8080/actuator/health | grep UP || exit 1

ENTRYPOINT ["./gradlew", "bootRun"]

