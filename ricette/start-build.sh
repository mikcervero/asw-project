#!/bin/bash

echo Building RICETTE Microservices

gradle clean

gradle build

docker build -t cmik/ricette:5.0.0 .

docker push cmik/ricette:5.0.0
