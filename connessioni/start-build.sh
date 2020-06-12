#!/bin/bash

echo Building CONNESSIONI Microservices

gradle clean

gradle build

docker build -t cmik/connessioni:5.0.0 .

docker push cmik/connessioni:5.0.0
