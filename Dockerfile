FROM alpine:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-alpine
EXPOSE 8080
COPY 

ENTRYPOINT ["java", "-jar", "app.jar"]
