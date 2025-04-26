# Stage 1
FROM maven:3.9.0-eclipse-temurin-21 AS build
WORKDIR /app

# Ajuste os caminhos para apontar para backend
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2
FROM eclipse-temurin:21-jdk AS runtime
WORKDIR /app
COPY --from=build /app/target/*-runner.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]
