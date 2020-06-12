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

cd ../ricette-seguite

sh start-container.sh

cd ../connessioni

sh start-container.sh

cd ../ricette

sh start-container.sh


