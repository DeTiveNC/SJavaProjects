# Dockerfile for building a custom application image
# Version: 1.0
FROM eclipse-temurin:21-alpine
LABEL maintainer="Nicolas Cao nicolascao12@gmail.com"
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
