
FROM amazoncorretto:23-alpine-jdk

COPY target/abarroteria-0.0.1-SNAPSHOT app.jar

ENTRYPOINT ["java" , "-jar" , "/app.jar"]