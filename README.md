# xtdb-pg-sample

An example repository using [XTDB](https://xtdb.com/) with PostgreSQL as transaction log and
document store.

> JDBC transaction logs and document stores depend on a 'connection pool' component - if you use
> both, they can share the same connection pool.

https://docs.xtdb.com/storage/jdbc/


## Usage

The development environment used [Docker](https://docs.docker.com/get-docker/) and
[docker-compose](https://docs.docker.com/compose/)

Start the system

```
docker-compose up -d
```

After startup you'll have a running nREPL server running on `localhost:47480`. Connect to it (e.g.,
`cider-connect`) and load the `xtdb-pg-sample.core` namespace.


## License

Copyright © 2021 Iván Perdomo

This Source Code Form is subject to the terms of the Mozilla Public
License, v. 2.0. If a copy of the MPL was not distributed with this
file, You can obtain one at http://mozilla.org/MPL/2.0/.
