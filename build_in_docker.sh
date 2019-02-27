#!/bin/bash

mvn package dockerfile:build -Dmaven.test.skip=true
