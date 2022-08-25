(ns xtdb-pg-sample.core
  (:require [xtdb.api :as xt])
  (:import [java.time Duration]))


(def config {:xtdb.jdbc/connection-pool {:dialect {:xtdb/module 'xtdb.jdbc.psql/->dialect}
	                                     :pool-opts {:maximumPoolSize 5}
	                                     :db-spec {:jdbcUrl (System/getenv "DATABASE_URL")}}
	         :xtdb/tx-log {:xtdb/module 'xtdb.jdbc/->tx-log
	                       :connection-pool :xtdb.jdbc/connection-pool
                           :poll-sleep-duration (Duration/ofSeconds 1)}
	         :xtdb/document-store {:xtdb/module 'xtdb.jdbc/->document-store
	                               :connection-pool :xtdb.jdbc/connection-pool}})


(comment

  (defonce node (xt/start-node config))
  ;; => #'xtdb-pg-sample.core/node


  (xt/submit-tx node [[::xt/put
                       {:xt/id :dbpedia.resource/Pablo-Picasso
                        :first-name "Pablo"
                        :last-name "Picasso"}]])
  ;; => #:xtdb.api{:tx-id 2, :tx-time #inst "2022-08-25T09:56:42.853-00:00"}


  (xt/q
   (xt/db node)
   '{:find [p1]
     :where [[p1 :first-name n]]
     :in [name]}
   "Pablo")
  ;; => #{[:dbpedia.resource/Pablo-Picasso]}


  (xt/pull
   (xt/db node)
   [:last-name]
   :dbpedia.resource/Pablo-Picasso)
  ;; => {:last-name "Picasso"}


  (xt/submit-tx node [[::xt/put
                       {:xt/id :dbpedia.resource/Pablo-Picasso
                        :last-name "Picazzo"}]])
  ;; => #:xtdb.api{:tx-id 4, :tx-time #inst "2022-08-25T09:57:10.863-00:00"}



  (xt/q
   (xt/db node)
   '{:find [(pull ?artist [*])]
     :where [[?artist :xt/id :dbpedia.resource/Pablo-Picasso]]})
  ;; => #{[{:last-name "Picazzo", :xt/id :dbpedia.resource/Pablo-Picasso}]}


  )
