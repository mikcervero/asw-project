#!/bin/bash

echo Starting All

echo ""
echo ""
echo ""

cd ./deploy

kubectl apply -f nameSpace.yaml

echo ""
echo ""
echo ""

cd ./api-gateway

sh start-container.sh

echo ""
echo ""
echo ""

cd ../postgres-all

sh start-container.sh

echo ""
echo ""
echo ""

cd ../kafka

sh start-container.sh

echo ""
echo ""
echo ""

echo Wait Before Starting Microservices Container

sleep 10s

cd ../ricette-seguite

sh start-container.sh

echo ""
echo ""
echo ""

echo Wait Before Starting Microservices Container

sleep 10s

cd ../connessioni

sh start-container.sh

echo ""
echo ""
echo ""

cd ../ricette

sh start-container.sh

echo ""
echo ""
echo ""

echo Wait One Minute Before Submitting Requests
