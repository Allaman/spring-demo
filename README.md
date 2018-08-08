# Java Spring Boot Demo Application

This is an rather minimalistic Java Spring Boot Demo application illustrating external configuration using different methods in a Docker deployment (see [Showcased](#showcased) for more information).

Additionally, you can spin up a minimal monitoring setup with preconfigured [Prometheus](https://prometheus.io/) and [Grafana](https://grafana.com/) services

> There is also a branch for the spring-boot 1.4 release (not fully equivalet)

## Requirements

- Java JDK >1.8
- Maven
- Docker
- Docker-compose
- default port 8080
- port 3000 and 9090 for Grafana and Prometheus

## Build Docker Image

Clone or download thist repository and cd into this folder.

```bash
mvn package dockerfile:build
```

## Run Docker Image

```bash
docker-copose up [-d]
```

## Accessing the demo application

- Application output of different external configuration options: `curl localhost:8080`
- Actuator security is disabled: `curl http://localhost:8080/env`
- All actuators are exposed and accessible: `curl http://localhost:8080/actuator/`

## External configuration showcased

1. Systemenvironment variables from .env file
2. Systemenvironment variables from docker-compose file
3. Config variables from .yaml file
4. Config variable from .properties file including nesting and arrays
5. Environment-based spring profile configuration

## Monitoring

```bash
docker-compose -f docker-compose.prom.yml up [-d]
```

Access [Grafana](localhost:3000) (admin:admin) and [Prometheus](localhost:9090) and find a configured datasource as well as dashboards for showing prometheus itself and a basic java Micrometer dashboard.

## Clean up containers

```bash
docker-compose -f docker-compose.prom.yml -f docker-compose.yml down --remove-orphans
```

## Official Documentation

- [spring.io getting started](https://spring.io/guides/gs/spring-boot/)
- [spring.io external config](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
- [spring.io endpoint security](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-monitoring.html)
- [spring.io spring application properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
- [Spring Boot Metric](https://spring.io/blog/2018/03/16/micrometer-spring-boot-2-s-new-application-metrics-collector)
- [Exposing Endpoints](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints-exposing-endpoints)