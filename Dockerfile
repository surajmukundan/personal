FROM openjdk:11
WORKDIR /opt
ADD build/libs/java-11-demo.jar /opt
ENTRYPOINT ["java","-jar","java-11-demo.jar"]
