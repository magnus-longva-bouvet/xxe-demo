#!/bin/sh
java -Dhttp.proxyHost=http-proxy -Dhttp.proxyPort=${proxyport} -Dhttps.proxyHost=http-proxy -Dhttps.proxyPort=${proxyport} -jar /app.jar