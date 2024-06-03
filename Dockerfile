FROM openjdk:20-jdk
WORKDIR /app
COPY target/ConstructionCompanyManagement-0.0.1-SNAPSHOT.jar /app/company.jar
ENTRYPOINT ["java","-jar","company.jar"]