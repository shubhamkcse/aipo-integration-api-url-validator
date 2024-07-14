# Use Maven to build the application
FROM maven:3.9.8-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and build the application
COPY src ./src
RUN mvn package -DskipTests

# Use a lighter image to run the application
FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/my-app-0.0.1-SNAPSHOT.jar ./my-app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "my-app.jar"]
