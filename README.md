# Spring Demo Application

This is an rather minimalistic Java Spring Boot Demo application illustrating external configuration using environment variables and yaml featuring different stages in a Docker deployment.

## Requirements

- Java JDK >1.8
- Maven
- Docker
- Docker-compose
- default port 8080

## Build Docker Image

Clone or download thist repository and change into this folder.

- mvn package docker:build

## Run Docker Image

- docker-copose up [-d]

## Access

- localhost:8080


## Official Documentation
[spring.io getting started](https://spring.io/guides/gs/spring-boot/)
[spring.io external config](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)