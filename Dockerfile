FROM openjdk:17-jdk-alpine

WORKDIR /app
EXPOSE 8090

COPY target/warehouse-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "warehouse-0.0.1-SNAPSHOT.jar"]
