#!/bin/bash

echo Starting Api-gateway in a Docker Container

kubectl apply -f deployment-api-gateway.yaml

kubectl apply -f service-api-gateway.yaml
 

 

