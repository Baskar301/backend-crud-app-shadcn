# Step 1: Build the project using Maven (using a Maven image)
FROM maven:3.8.1-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the source code to the container
COPY . .

# Run Maven to clean, compile, and package the application (without running tests)
RUN mvn clean package -DskipTests

# Step 2: Use an OpenJDK image for running the Java application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container for the runtime image
WORKDIR /app

# Copy the compiled JAR file from the 'build' stage into the runtime container
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the default port for the Spring Boot app (change if necessary)
EXPOSE 8080

# Command to run the Java application
ENTRYPOINT ["java", "-jar", "app.jar"]
