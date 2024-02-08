#!/bin/bash

curl http://localhost:8080/oracle/cloud-bank/api/accounts

curl -i -H "Content-Type: application/json" -d @${PWD}/src/main/resources/data.json -X POST http://localhost:8080/oracle/cloud-bank/api/accounts
