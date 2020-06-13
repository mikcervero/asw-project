#!/bin/bash

echo Starting All

cd ./deploy

kubectl apply -f nameSpace.yaml

cd ./api-gateway

sh start-container.sh

cd ../postgres-all

sh start-container.sh

cd ../kafka

sh start-container.sh

echo Wait Before Starting Microservices Container

sleep 30s

cd ../ricette-seguite

sh start-container.sh

echo Wait Before Starting Microservices Container

sleep 10s

cd ../connessioni

sh start-container.sh

echo Wait Before Starting Microservices Container

cd ../ricette

sh start-container.sh


echo Wait One Minute Before Try Request
