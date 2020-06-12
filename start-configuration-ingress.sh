#!/bin/bash

echo Ingress Controller Configuration

kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-0.32.0/deploy/static/provider/cloud/deploy.yaml

kubectl get pods -n ingress-nginx

sudo vi /etc/hosts


