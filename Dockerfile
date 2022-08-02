FROM openjdk:8

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
EXPOSE 18023 
CMD ["./mvnw", "spring-boot:run"]