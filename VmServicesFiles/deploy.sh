#!/bin/bash

cd /docker
sed -i "s/os2_api:.*/os2_api:$1/g" docker-compose.override.yml
docker-compose up -d
