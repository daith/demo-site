FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/demo.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]