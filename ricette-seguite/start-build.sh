#!/bin/bash

echo Building RICETTE-SEGUITE Microservices

gradle clean

gradle build

docker build -t cmik/ricette-seguite:5.0.0 .

docker push cmik/ricette-seguite:5.0.0
