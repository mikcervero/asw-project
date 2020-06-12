#!/bin/bash

echo Starting Zookeeper in a Docker Container

kubectl apply -f deployment-zookeeper.yaml

kubectl apply -f service-zookeeper.yaml

kubectl apply -f deployment-kafka.yaml
 
kubectl apply -f service-kafka.yaml
 

