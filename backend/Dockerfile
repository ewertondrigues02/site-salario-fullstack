# Stage 1: build com JDK 21 + Maven manualmente
FROM eclipse-temurin:21-jdk AS build

# Instala Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: runtime (só a JDK limpa)
FROM eclipse-temurin:21-jdk AS runtime
WORKDIR /app

COPY --from=build /app/target/*-runner.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]
