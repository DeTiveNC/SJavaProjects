# Dockerfile for building a custom application image
# Version: 1.0
FROM vegardit/graalvm-maven:latest-java21
LABEL maintainer="Nicolas Cao nicolascao12@gmail.com"
COPY src /home/app/src
COPY pom.xml /home/app
#Build a native executable
RUN mvn -f /home/app/pom.xml -Pnative native:compile -DskipTests
WORKDIR /home/app/target
#Entrypoint command present in Kubernetes deployment
CMD [ "./home/app/taget/docker" ]