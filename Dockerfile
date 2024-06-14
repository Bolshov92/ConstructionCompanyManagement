FROM openjdk:20-jdk
ARG JAR_FILE=target/*.jar
COPY target/ConstructionCompanyManagement-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8081