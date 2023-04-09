FROM maven:3.8.7-openjdk-18-slim AS build
COPY . .
RUN mvn clean package

FROM openjdk:18-slim
RUN mkdir app
COPY --from=build /target/*.jar /app/app.jar
WORKDIR /app
ENTRYPOINT java -jar app.jar