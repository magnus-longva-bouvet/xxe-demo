#!/bin/sh
if [ -n "$use_proxy" ]; then
    java -Dhttp.proxyHost=http-proxy -Dhttp.proxyPort=${HTTP_PROXY_SERVICE_PORT} -Dhttps.proxyHost=http-proxy -Dhttps.proxyPort=${HTTP_PROXY_SERVICE_PORT} -jar /app.jar
else
    java -jar /app.jar
fi