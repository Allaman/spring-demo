#!/bin/bash

docker-compose -f docker-compose.prom.yml -f docker-compose.yml down --remove-orphans
