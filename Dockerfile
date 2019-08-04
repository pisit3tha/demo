FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/demo-0.0.1.jar

COPY ${JAR_FILE} demo-0.0.1.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/demo-service.jar"]
