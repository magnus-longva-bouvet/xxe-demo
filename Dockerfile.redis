FROM alpine:3.16
RUN apk add redis && mkdir /redis && chown 1000:1000 -R /redis
USER 1000
CMD redis-server --port ${REDIS_SERVICE_PORT} --requirepass "${REDIS_PASSWORD}" --dir "/redis"