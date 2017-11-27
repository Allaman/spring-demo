# Spring Demo Application

This is an rather minimalistic Java Spring Boot Demo application illustrating external configuration using different methods in a Docker deployment (see [Showcased](#Showcased) for more information).

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
- Actuator security is disabled: curl http://localhost:8080/env

## Showcased

1. Systemenvironment variables from .env file
1. Systemenvironment variables from docker-compose file
1. Config variables from .yaml file
1. Config variable from .properties file including nesting and arrays
1. Environment-based spring profile configuration

## Official Documentation

[spring.io getting started](https://spring.io/guides/gs/spring-boot/)
[spring.io external config](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
[spring.io endpoint security](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-monitoring.html)
[spring.io spring application properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)