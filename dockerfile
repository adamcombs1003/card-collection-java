FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/CardsMongoDb-0.0.2.jar
COPY ${JAR_FILE} CardsMongoDb-0.0.2.jar
ENTRYPOINT ["java","-jar","/CardsMongoDb-0.0.2.jar"]