#!/bin/sh
if [ -n "$use_proxy" ]; then
    java -Dhttp.proxyHost=http-proxy -Dhttp.proxyPort=${proxyport} -Dhttps.proxyHost=http-proxy -Dhttps.proxyPort=${proxyport} -jar /app.jar
else
    java -jar /app.jar
fi