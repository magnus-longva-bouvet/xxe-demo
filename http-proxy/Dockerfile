FROM ubuntu/squid
COPY cmd.sh /
RUN apt update && apt install gettext -y && touch /squid.conf && chown 1000:1000 /cmd.sh /squid.conf
COPY squid.conf /squid.conf.template
USER 1000
ENTRYPOINT []
CMD /cmd.sh