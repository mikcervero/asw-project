#!/bin/bash

echo Tests projects...
echo ""
echo ""
echo "Connessioni"
echo ""


curl --header "Content-Type: application/json" \
--request POST \
--data '{"follower":"Giorgia","followed":"Cristiano"}' \
http://instagnam/connessioni

echo ""
echo ""
echo "Provo ad inviare una connessione che già ho"

curl --header "Content-Type: application/json" \
--request POST \
--data '{"follower":"Gennaro","followed":"Cristiano"}' \
http://instagnam/connessioni


echo ""
echo ""
echo ""
echo "Ricette"
echo ""
#curl http://instagnam/ricette
curl --header "Content-Type: application/json" \
--request POST \
--data '{"autore":"Cristiano","titolo":"Tagliatelle al ragu", "preparazione":"... poi impiatta"}' \
http://instagnam/ricette

echo ""
echo ""
echo "Provo ad inviare una ricetta che già ho"

curl --header "Content-Type: application/json" \
--request POST \
--data '{"autore":"Cristiano","titolo":"Pizza e mortazza", "preparazione":"Metti la mortadella nella pizza"}' \
http://instagnam/ricette



