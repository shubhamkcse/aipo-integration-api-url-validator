# Use Maven to build the application
FROM maven:3.8.5-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn package

# Use a minimal base image for the final artifact
FROM openjdk:11-jre-slim

# Copy the JAR file from the build stage
COPY --from=build /app/target/my-app.jar /app/my-app.jar

# Set the entry point
ENTRYPOINT ["java", "-jar", "/app/my-app.jar"]
