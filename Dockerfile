FROM amazoncorretto:11-alpine-jdk
MAINTAINER nicolasdembrowky
COPY target/portfolioBack-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]