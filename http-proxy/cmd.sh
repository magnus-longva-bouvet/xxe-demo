#!/bin/bash
echo ${CA_KEY} | base64 -d > /config/ca.key.pem
/app/inkfish -cacert /config/ca.pem -cakey /config/ca.key.pem -metadata none -config /config