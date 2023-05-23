# Use a base image jdk
FROM openjdk:11-jdk-slim AS build
WORKDIR /app

# Copy source code to the container
COPY . .

# Build the application with Maven
RUN ./mvnw package

# Create a new image
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/demo.jar .

# Start application
CMD ["java", "-jar", "demo.jar"]
