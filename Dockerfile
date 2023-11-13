FROM openjdk:20-jdk-oracle

EXPOSE 8080

ADD build/libs/rest-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]