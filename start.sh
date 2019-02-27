#!/bin/bash

docker-compose -f docker-compose.yml -f docker-compose.prom.yml up -d
