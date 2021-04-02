FROM openjdk:11-alpine
WORKDIR /opt
ADD build/libs/java-11-demo.jar /opt
