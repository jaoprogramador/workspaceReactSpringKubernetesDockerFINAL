# INDICE
# ==========
# Intro
# Config
# API
# Migration Flyway 
# JPA
# Testing
# Dockerizing
# Actions


# INICIAR proyecto
# =================
# refresh y clean proyect
# ejecutamos el GOAL CLEAN BUILD que genera el jar
# arrancamos DCOCKER-DESCKTOP
# arrancamos el contenedor
# docker run -p 8080:8080  jao/26bookmarker-api

# Useful commands:DOCKER
# ===================
# crear la imagen Docker con Spring Boot
	mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=jao/26bookmarker-api
# construir la imagen Docker con jib
	mvnw jib:build -Dimage=jao/26bookmarker-api
# Esto es útil si tienes Docker instalado localmente y quieres crear la imagen y ejecutarla en tu entorno local.
	mvnw jib:dockerBuild -Dimage=jao/26bookmarker-api
# ejecutar la imagen Docker que has creado (ya sea con spring-boot:build-image o jib:dockerBuild):

	docker run -p 8080:8080  jao/26bookmarker-api
	
## How to run?: Nos clonamos el proyecto copiamos docker-compose.yml ,docker-compose-app.yml y run.sh en el workspace donde esté la aplicacion(NO DENTRO DE ELLA)

```shell
$ git clone https://github.com/jaoprogramador/springKubernetes.git
$ cd springKubernetes
$ ./run.sh start
$ ./run.sh stop

$ ./run.sh start_infra
$ ./run.sh stop_infra
```

* To start only dependent services

```shell
$ ./run.sh start_infra
$ ./run.sh stop_infra
```

## API: http://localhost:8080/api/bookmarks
## http://localhost:3000

## COMANDOS Docker
## ===============
## CONSTRUIR UNA IMAGEN DOCKER
## 	docker build -t springjao .
## VER TODAS LAS REDES DISPONIBLES
## 	docker network ls
## LISTAR LOS CONTENEDORES , ESTADO, PUERTOS...
## 	docker ps
## ARRANCAR Y PARAR CONTENEDORES
## 	docker start mysqldb
## 	docker start springboot
## docker stop mysqldb
## ELIMINAR LA RED DENOMINADA MY-NETWORK
## 	docker network rm MY-NETWORK
## CREAR IMAGEN DE MYSQL, EL CONTENEDOR Y LA BD
## ====================================
## CREAR IMAGEN DE MYSQL
## 	docker pull mysql
## EJECUTAR EL CONTENEDOR
## 	docker run -d --name mysqldb --network api_network_JAO -p 3305:3306 -e MYSQL_ROOT_PASSWORD=jaoprogramador1234 mysql:latest
## ACCEDER AL CONTENEDOR DE BD POR USU Y PASS
## 	docker exec -it mysqldb mysql -u root -p
## MOSTRAR LAS BD
## 	show databases
## CREAR LA BD 
## 	create database dankdb;
## EJECUTA EL CONTENEDOR springboot EN LA RED api_network_JAO EN EL PUERTO 8080
## 	docker run -d --name springboot --network api_network_JAO -p 8080:8080 springjao:latest
	
## ========================================
## CUANDO QUIERES HACER CAMBIOS EN LA APP y DEPLOYAR EN CONTAINER DE DOCKER
## Reconstruye tu JAR
## LANZA L GOAL CLEANINSTALL SIN TEST
## Reconstruye la imagen Docker
## docker build -t springjao .
## Elimina el contenedor anterior de tu app (si existe)
## docker rm -f springboot
## Lanza el contenedor con la red compartida
## docker run -d --name springboot --network api_network_JAO -p 8080:8080 springjao:latest

#URLs de interes
https://kubernetes.io/docs/concepts/workloads/


