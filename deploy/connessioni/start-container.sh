#!/bin/bash

echo Starting Connessioni Microservice in a Docker Container

kubectl apply -f deployment-connessioni.yaml

kubectl apply -f service-connessioni.yaml
