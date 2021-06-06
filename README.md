# crux-pg-sample

An example repository using [Crux](https://opencrux.com) with PostgreSQL as transaction log and
document store.

> Crux nodes can use JDBC databases to store their transaction logs and/or document stores.

https://opencrux.com/reference/21.05-1.17.0/jdbc.html

> This project contains `crux.jdbc` which is an implementation of `TxLog` backend by a
> JDBC-compatible database of your choosing, for strong durability guarantees in situations where
> Kafka cannot be used and scalability is less important. This implementation provides the same
> semantics as the `crux-kafka`.

https://github.com/juxt/crux/tree/21.05-1.17.0/crux-jdbc


## Usage

The development environment used [Docker](https://docs.docker.com/get-docker/) and
[docker-compose](https://docs.docker.com/compose/)

Start the system

```
docker-compose up -d
```


## License

Copyright © 2021 Iván Perdomo

This Source Code Form is subject to the terms of the Mozilla Public
License, v. 2.0. If a copy of the MPL was not distributed with this
file, You can obtain one at http://mozilla.org/MPL/2.0/.
