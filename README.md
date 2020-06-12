# INSTAGNAM 



## Esecuzione 

Per eseguire questo progetto: 

Prima cosa da fare:

eseguire start-configuration-ingress.sh *solo una volta*,

verificare che l'output ottenuto contenga una stringa del tipo:

*ingress-nginx-controller..*

una volta inserita la password, vi troverete nel file /etc/hosts qui dovrete inserire `instagnam` vicino all'ip dei nodi di k8s

ex. io avevo il seguente file

192.168.1.171 devops1
127.0.0.1       localhost
127.0.0.1 kubernetes.docker.internal 

a fianco a kubernates.... ho inserito instagnam, ottenendo:

*127.0.0.1 kubernetes.docker.internal instagnam*



Ogni microservizio contiene due file .sh `start-build.sh` e   `start-container.sh` che fanno riferimento ai file *Dockerfile*,  *Deployment-nameMicroservice.yaml*, *Service-nameMicroservice.yaml*.

Eseguendo il primo script menzionato, si crea l'immagine docker a partire dal dockerfile e succesivamente viene pushata sul docker registry, questo comprende anche i comandi `gradle clean` e `gradle build`.

Attualmente è presente nello script il mio user docker hub:

modificando  *cmik/..* con *<user docker/registry>/..*. 

Quindi cambiare anche il file  *Deployment-nameMicroservices.yaml* :

modificando  *image: cmik/..* con *image: <user docker/registry>/..*

**vi prego di modificare esclusivamente ciò che riguarda gli account personali**.

Il lancio di ogni file .sh richiede il posizionamento all'interno della directory dove si trova il file script stesso.

1. lanciare tutti i file start-build.sh (se non è stato modificato codice non è necessario eseguire questo file, potete direttamente eseguire gli script per la creazione dei container, che prenderanno l'ultima immagine nel vostro o nel mio registry Docker, *vi consiglio per le volte successive di eseguirlo sempre soprattuto se il git pull ha riportato la presenza di modifiche, in modo da rimanere tutti allineati*).

2. posizionatevi sulla directory dell'api-gateway, quindi eseguite `start-api-gateway-container.sh ` in una finestra del terminale dedicato, quest'ultimo è disponibile all'indirizzo: `http://instagnam`.
La richiesta ad un microservizio ha la seguente struttura: `http://instagnam/ricette`, `http://instagnam/connessioni`,`http://instagnam/ricetteseguite`

3. eseguite il resto dei file.sh nelle stesse modalità sopra riportate, con la differenza che non rimane appeso nulla.

Vi lascio alcuni comandi utili:

1.  verifica dei deployment,pod,service e replicaset lanciati: `kubectl  --namespace=asw-project get all `  se  in READY è riportato un 0/1 cè qualcosa che non  va e consiglio di eseguire il comando successivo:

2.  fornisce il log del pod, non che l'output di un comune java -jar, l'output di Spring: `kubectl logs --namespace=asw-project <nome del pod> ` 

3. per eliminare un pod o un deployment o un service : `kubectl delete --namespace=asw-project pod/(deployment.apps/,service/) <nome del pod, deployment, servie> `
  
4. per la descrizione di un service   `kubectl describe svc --namespace=asw-project <name service> `
  
5. per la descrizione di un deployment   `kubectl describe deployment --namespace=asw-project <name deployment> ` 
 
6. per la descrizione di un pod   `kubectl describe pod --namespace=asw-project <name pod> `

7. per tutti gli altri comandi inserire il namespace in cui stiamo lavorando ` --namespace=asw-project `.

Per la comunicazione tra microservizi non va usato un indirizzo ip e una porta, ma nell'application properties nel tag host va inserito: `<nome del service del microservizio con cui dovete comunicare>.asw-project.svc.cluster.local` questo ovviamente vale anche per la connessione con il db.
  
ex. consul-service.asw-project.svc.cluster.local

Vi consiglio inoltre di ricordarvi di startare oltre a docker anche kubernetes, lo start di docker non è strettamente legato allo start di k8s. 
Verificare che il context sia *docker desktop* e che il local cluster sia nello stato *enable*.




