# Wallet

An ongoing project for a proof-of-concept of a digital account/money wallet API.
 
The idea is to base the domain modeling on accounting, so we can get closer to a real-world scenario.

This project uses Ktor + Koin + Exposed + Postgres.


## Getting Started

```
$ gradle build
$ docker-compose build
$ docker-compose up
```

## Containers
- App: Contains the application itself
- DB: Contains a Postgres database
- PgAdmin: A WebInterface for managing Postgres (you can disable this)

## LICENSE
See LICENSE.md