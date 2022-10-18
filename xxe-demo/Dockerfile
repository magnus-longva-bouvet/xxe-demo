FROM maven:3.8.2-jdk-11 as BUILD
COPY . .
RUN mvn install

FROM alpine:3.16
COPY --from=BUILD /root/.m2/repository/no/sikkerhetshull/xxe/0.0.1-SNAPSHOT/xxe-0.0.1-SNAPSHOT.jar /app.jar
COPY secret_api_key.txt dtd.xml /
RUN apk add --no-cache openjdk11-jre
USER 1000
CMD ["java", "-jar", "/app.jar"]
