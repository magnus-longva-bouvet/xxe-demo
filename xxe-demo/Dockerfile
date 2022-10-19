FROM maven:3.8.2-jdk-11 as BUILD
COPY . .
RUN mvn install

FROM alpine:3.16
COPY --from=BUILD /root/.m2/repository/no/sikkerhetshull/xxe/0.0.1-SNAPSHOT/xxe-0.0.1-SNAPSHOT.jar /app.jar
COPY secret_api_key.txt ca.pem cmd.sh /
RUN apk add --no-cache openjdk11-jre ca-certificates && cat /ca.pem >> /etc/ssl/certs/ca-certificates.crt && update-ca-certificates && chown 1000:1000 /cmd.sh
USER 1000
CMD /cmd.sh
