# Use uma imagem base do OpenJDK
FROM openjdk:21-jdk-slim as build

# Copie os arquivos do projeto para o container
COPY target/salario-1.0.0-SNAPSHOT-runner.jar /app.jar

# Defina a variável de ambiente que configura o host e a porta do Quarkus
ENV QUARKUS_HTTP_HOST=0.0.0.0
ENV QUARKUS_HTTP_PORT=8081

# Comando para rodar o JAR
CMD ["java", "-jar", "/app.jar"]
