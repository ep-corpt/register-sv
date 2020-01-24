FROM openjdk:8-jdk-alpine3.9

WORKDIR app/

COPY target/register-sv-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9001

ENTRYPOINT ["java", "-Dspring.config.location=/app/config/application.yml",  "-jar", "app.jar"]