#!/bin/sh
ENV=$1

if [ -z "$ENV" ]
then
    ENV='local'
fi
ENV_FILE="$ENV"_"env_properties"

mvn clean package && docker build -f ./docker/Dockerfile -t br.com.fmoraes/environment-aware-configuration .
docker rm -f environment-aware-configuration || true && docker run --env-file=./docker/$ENV_FILE -d -p 8080:8080 -p 4848:4848 --name environment-aware-configuration br.com.fmoraes/environment-aware-configuration
