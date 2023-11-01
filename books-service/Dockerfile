FROM openjdk:17-alpine

ARG APP_JAR
COPY target/${APP_JAR} application.jar
ENTRYPOINT ["java", "-jar", "/application.jar"]
