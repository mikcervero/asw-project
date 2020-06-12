#!/bin/bash

echo Starting Ricette-seguite Microservice in a Docker Container

kubectl apply -f deployment-ricette-seguite.yaml

kubectl apply -f service-ricette-seguite.yaml
