FROM openjdk:11-jre-slim
MAINTAINER "Buggify App <neoOkpara@neoOkpara.io>"
WORKDIR /app
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ./app.jar
CMD ["java", "-jar", "/app/app.jar"]

EXPOSE 8080