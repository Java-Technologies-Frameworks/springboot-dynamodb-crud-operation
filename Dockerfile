# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim-buster

# Set the working directory in the container
WORKDIR /app
# copy the jar which created in intelij idea libs folder to container build/lib directory
COPY build/libs/* build/lib/

# Copy the application JAR file into the container at the working directory
COPY build/libs/jtf-dynamodb-application-1.0.0.jar build/
#WORKDIR instruction sets the working directory for any subsequent COPY, ADD, RUN, CMD, or ENTRYPOINT 
WORKDIR /app/build
#It informs Docker that the application inside the container is expected to be accessible on port 8080
EXPOSE 8080
#when container is running from image it will start executing the jar of java application
ENTRYPOINT java -jar jtf-dynamodb-application-1.0.0.jar
