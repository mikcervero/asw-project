#!/bin/bash

echo Building API-GATEWAY Microservices

gradle clean

gradle build

docker build -t cmik/api-gateway:1.1.2 .

docker push cmik/api-gateway:1.1.2
