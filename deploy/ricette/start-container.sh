#!/bin/bash

echo Starting Ricette Microservice in a Docker Container

kubectl apply -f deployment-ricette.yaml

kubectl apply -f service-ricette.yaml
