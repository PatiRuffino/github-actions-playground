FROM maven:3-amazoncorretto-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM mcr.microsoft.com/openjdk/jdk:21-distroless
VOLUME /tmp
EXPOSE 8082
COPY --from=build /home/app/target/github-actions-playground-0.0.1.jar github-actions-playground.jar
ENTRYPOINT ["java","-jar","/github-actions-playground.jar"]