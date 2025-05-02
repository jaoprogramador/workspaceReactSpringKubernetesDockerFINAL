INICIAR
==========
1.-Arrancamos docker-desktop
2.-Arrancamos los contenedores e BD y de la API
3.-docker-compose -f docker-compose.yml -f docker-compose-app.yml up -d
4.-Abrimos en croe la URL del FRONT que se comunica con los contenedores
	http://localhost:13000/bookmarks




//EJECUTAR VARIOS ARCHIVOS: BD y APP
	docker-compose -f docker-compose.yml -f docker-compose-app.yml up -d
PARA VER LOS LOGS
	docker-compose -f docker-compose.yml -f docker-compose-app.yml logs -f
//PARA TODOS LOS CONTENEDORES
	docker-compose stop
//PARA BORRAR UN CONTENEDOR
	docker-compose rm
//PARA LEVANTAR UN CONTENEDOR
	docker-compose up -d
//para LEVANTAR UN CONTENEDOR Y COMPILAR CON LOS NUEVOS CAMBIOS HECHOS
	docker-compose up -d --build

script shell run.shellnecesitamos dar permisos al fichero en linux
	chmod +x run.sh
	./run.sh
	
npx create-react-app reactjs-demo --template typescript
npx create-next-app nextjs-demo --ts
arrancamos con yarn dev

CREAMOS EL PROYECTO Y AGREGAMOS BOOTSTRAP
==================================
npx create-next-app bookmarker-ui-nextjs --ts
cd bookmarker-ui-nextjs
npm i bootstrap@5.2.0
yarn dev

ERROR AL DEPLOYAR EN DOCKER CON VALIDATE TABLE
======================================
LO HE ARREGLADO BORRANDO LA CACHE LOS CONTEEDORES Y REDEPLOYANDO 
Paso 1: Parar y eliminar todos los contenedores
	docker-compose -f docker-compose.yml -f docker-compose-app.yml down
Paso 2 (opcional): Eliminar volúmenes (para borrar la DB)
	docker-compose -f docker-compose.yml -f docker-compose-app.yml down -v
Paso 3: Reconstruir todo
	docker-compose -f docker-compose.yml -f docker-compose-app.yml build
Paso 4: Levantar de nuevo
	docker-compose -f docker-compose.yml -f docker-compose-app.yml up

KUBERNETES
============
# Muestra una lista de todos los Pods en el namespace actual
kubectl get pods

# Muestra todos los recursos (pods, services, deployments, etc.) en el namespace actual
kubectl get all

# Crea un Pod llamado 'bookmarker-api' con la imagen especificada y expone el puerto 8080
kubectl run bookmarker-api --image=jaoprogramador/26bookmarker-api --port=8080

# Muestra los logs en tiempo real del Pod '26bookmarker-api'
kubectl logs 26bookmarker-api -f

# Muestra detalles completos del Pod '26bookmarker-api', incluyendo eventos y errores
kubectl describe pods 26bookmarker-api

# Elimina el Pod '26bookmarker-api'
kubectl delete pods 26bookmarker-api

# Aplica (crea o actualiza) un recurso definido en el archivo 'pod.yaml'
kubectl apply -f pod.yaml

# Elimina el recurso definido en el archivo 'pod.yaml'
kubectl delete -f pod.yaml

# Crea un Deployment llamado '26bookmarker-api' a partir de una imagen de contenedor
kubectl create deployment 26bookmarker-api --image=jaoprogramador/26bookmarker-api

# Elimina el Deployment llamado '26bookmarker-api'
kubectl delete deployment.apps/26bookmarker-api

# Genera el YAML del Deployment sin aplicarlo (modo prueba)
kubectl create deployment 26bookmarker-api --image=jaoprogramador/26bookmarker-api --dry-run=client -o yaml > deployment.yaml

# Aplica el archivo 'deployment.yaml' para crear o actualizar el recurso
kubectl apply -f deployment.yaml

# Elimina el recurso definido en el archivo 'deployment.yaml'
kubectl delete -f deployment.yaml

# Escala el Deployment '26bookmarker-api' a 3 réplicas
kubectl scale deployment 26bookmarker-api --replicas=3

# Muestra el historial de actualizaciones del Deployment '26bookmarker-api'
kubectl rollout history deployments 26bookmarker-api

# Aplica todos los archivos YAML del directorio actual
kubectl apply -f .
