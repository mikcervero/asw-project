#!/bin/bash

echo Starting Postgres  in a Docker Container


kubectl create configmap postgres-config-ricette-seguite --namespace=asw-project --from-literal=postgres.service.name=postgres-ricette-seguite-service --from-literal=postgres.db.name=ricette-seguitedb

kubectl create configmap postgres-config-ricette --namespace=asw-project --from-literal=postgres.service.name=postgres-ricette-service --from-literal=postgres.db.name=ricettedb

kubectl create configmap postgres-config --namespace=asw-project --from-literal=postgres.service.name=postgres-connessioni-service --from-literal=postgres.db.name=connessionidb

kubectl create secret generic db-security --from-literal=db.user.name=postgres --from-literal=db.user.password=postgres  --namespace=asw-project

kubectl apply -f postgres-storage-connessioni.yaml

kubectl apply -f deployment-postgres-connessioni.yaml

kubectl apply -f service-postgres-connessioni.yaml

kubectl apply -f postgres-storage-ricette.yaml

kubectl apply -f deployment-postgres-ricette.yaml

kubectl apply -f service-postgres-ricette.yaml

kubectl apply -f postgres-storage-ricette-seguite.yaml

kubectl apply -f deployment-postgres-ricette-seguite.yaml

kubectl apply -f service-postgres-ricette-seguite.yaml
