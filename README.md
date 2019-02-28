# Java Spring Boot Demo Application

This is an rather minimalism Java Spring Boot Demo application illustrating external configuration using different methods in a Docker deployment (see [Showcased](#showcased) for more information).

Additionally, you can spin up a minimal monitoring setup with preconfigured [Prometheus](https://prometheus.io/) and [Grafana](https://grafana.com/) services including metrics from the JVM, your hosts and your docker container. The stack itself is deployed as docker container so there is **no pollution** of your system.

> There is also a branch for the spring-boot 1.4 release (not fully equivalent)

## Requirements

- Docker
- Docker-compose
- default port 8080 for the application
- port 3000 and 9090 for Grafana and Prometheus
- port 9100 and 9200 for NodeExporter and cAdvisor

If you want to build the application without Docker:

- Java JDK >1.8
- Maven

## Build the build Docker image

Clone or download this repository and cd into this folder.

```sh
docker build -f Dockerfile.build -t spring-builder .
```

## Build the application inside the build container

```sh
docker run -v --rm --name spring-builder /var/run/docker.sock:/var/run/docker.sock spring-builder
```

## Start demo application and Prometheus stack

```bash
sh start.sh
```

## Stop demo application and Prometheus stack

```bash
sh stop.sh
```

## Accessing the demo application

- Application output of different external configuration options: `curl localhost:8080`
- Actuator security is disabled: `curl http://localhost:8080/env`
- All actuators are exposed and accessible: `curl http://localhost:8080/actuator/`

## External configuration showcased

1. System environment variables from .env file
2. System environment variables from docker-compose file
3. Config variables from a YAML file
4. Config variable from a application properties file including nesting and arrays
5. Environment-based spring profile configuration

## Monitoring

![Dashboard](https://knowledge.rootknecht.net/user/pages/01.home/monitoring-with-prometheus/grafana.png)

![Dashboard2](https://knowledge.rootknecht.net/user/pages/01.home/monitoring-with-prometheus/grafana2.png)


Access [Grafana](localhost:3000) (admin:admin) and [Prometheus](localhost:9090) and find a configured data source as well as dashboards for showing Prometheus itself and a basic java Micrometer dashboard.

## Official Documentation

- [spring.io getting started](https://spring.io/guides/gs/spring-boot/)
- [spring.io external config](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
- [spring.io endpoint security](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-monitoring.html)
- [spring.io spring application properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
- [Spring Boot Metric](https://spring.io/blog/2018/03/16/micrometer-spring-boot-2-s-new-application-metrics-collector)
- [Exposing Endpoints](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints-exposing-endpoints)
