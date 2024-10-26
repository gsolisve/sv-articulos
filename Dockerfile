FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /sv-articulos
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /sv-articulos
COPY --from=build /sv-articulos/target/*.war sv-articulos-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "sv-articulos-1.0.0.jar"]