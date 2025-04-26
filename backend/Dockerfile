# Stage 1: build com Maven + JDK 21
FROM maven:3.9.0-jdk-21 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: runtime com Temurin 21
FROM eclipse-temurin:21-jdk AS runtime
WORKDIR /app

COPY --from=build /app/target/*-runner.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]
