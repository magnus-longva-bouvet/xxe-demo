#!/bin/sh
envsubst < /squid.conf.template > /squid.conf
/usr/sbin/squid -f /squid.conf -NYC