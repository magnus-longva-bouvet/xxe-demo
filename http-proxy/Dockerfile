FROM bsycorp/inkfish
COPY proxy.conf ca.pem /config/
COPY cmd.sh /
USER root
RUN chown -R inkfish:inkfish /cmd.sh /config/
USER 10001
CMD /cmd.sh