FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY build/libs/* build/lib/

COPY build/libs/jtf-dynamodb-application-1.0.0.jar build/

WORKDIR /app/build
EXPOSE 8585
ENTRYPOINT java -jar jtf-dynamodb-application-1.0.0.jar
