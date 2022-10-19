FROM alpine:3.16
COPY --from=bsycorp/inkfish /app/inkfish /app/inkfish
COPY proxy.conf ca.pem /config/
COPY cmd.sh /
USER root
RUN chown -R 10001:10001 /cmd.sh /config/
USER 10001
CMD /cmd.sh