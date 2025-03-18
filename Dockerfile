# Usa uma imagem do OpenJDK como base
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR do build para o container
# COPY target/spring-boot-docker-0.0.1-SNAPSHOT.jar app.jar
VOLUME /app

# Copia os arquivos para o container
COPY . /app/

# Expõe a porta do app
EXPOSE 8080

# Instala o maven
RUN apt-get update && apt-get install -y maven

# Comando para manter o container em execução
ENTRYPOINT ["tail", "-f", "/dev/null"]
