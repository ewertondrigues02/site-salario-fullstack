# Stage 1
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Ajuste os caminhos para apontar para backend
COPY backend/pom.xml .
COPY backend/src ./src

RUN mvn clean package -DskipTests

# Stage 2
FROM eclipse-temurin:17-jdk AS runtime
WORKDIR /app
COPY --from=build /app/target/*-runner.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]
