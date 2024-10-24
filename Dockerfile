FROM openjdk:17-jdk-slim AS build
WORKDIR /sv-articulos
COPY . .
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /sv-articulos
COPY --from=build /sv-articulos/target/*.war sv-articulos-1.0.0.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar sv-articulos-1.0.0.jar"]