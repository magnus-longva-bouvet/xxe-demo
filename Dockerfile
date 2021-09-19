FROM maven:3.8.2-jdk-11 as BUILD
COPY . .
RUN mvn install

FROM alpine:3.13
COPY --from=BUILD /root/.m2/repository/no/sikkerhetshull/xxe/0.0.1-SNAPSHOT/xxe-0.0.1-SNAPSHOT.jar /app.jar
RUN apk add openjdk11-jre
CMD ["java", "-jar", "/app.jar"]