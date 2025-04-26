# Stage 1: build
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copia pom.xml e código-fonte
COPY pom.xml .
COPY src ./src

# Gera o JAR nativo (ou JAR empacotado)
RUN mvn clean package -DskipTests

# Stage 2: runtime
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app

# Copia o JAR gerado no primeiro stage
COPY --from=build /app/target/*-runner.jar /app/app.jar

# Expõe porta (se necessário)
EXPOSE 8081

# Comando de inicialização
ENTRYPOINT ["java","-jar","/app/app.jar"]

