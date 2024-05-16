(defproject xtdb-pg-sample "0.1.0-SNAPSHOT"
  :description "Example project of XTDB with PostgreSQL"
  :url "https://github.com/iperdomo/xtdb-pg-sample"
  :license {:name "Mozilla Public License Version 2.0"
            :url "https://www.mozilla.org/en-US/MPL/2.0/"}
  :dependencies [[org.clojure/clojure "1.11.3"]
                 [com.xtdb/xtdb-core "1.24.3"]
                 [com.xtdb/xtdb-jdbc "1.24.3"]
                 [org.postgresql/postgresql "42.2.18"]]
  :repl-options {:init-ns xtdb-pg-sample.core
                 :host "0.0.0.0"
                 :port 47480})
