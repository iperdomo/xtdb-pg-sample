(defproject crux-pg-sample "0.1.0-SNAPSHOT"
  :description "Example project of Crux with PostgreSQL"
  :url "https://github.com/iperdomo/crux-pg-sample"
  :license {:name "Mozilla Public License Version 2.0"
            :url "https://www.mozilla.org/en-US/MPL/2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [juxt/crux-jdbc "21.05-1.17.0-beta"]
                 [juxt/crux-metrics "21.05-1.17.0-alpha"]
                 [org.postgresql/postgresql "42.2.18"]]
  :repl-options {:init-ns crux-pg-sample.core
                 :host "0.0.0.0"
                 :port 47480})
