(ns crux-pg-sample.core
  (:require [crux.api :as crux])
  (:import [java.time Duration]))

(def config {:crux.jdbc/connection-pool {:dialect {:crux/module 'crux.jdbc.psql/->dialect}
	                                 :pool-opts {:maximumPoolSize 5}
	                                 :db-spec {:jdbcUrl (System/getenv "DATABASE_URL")}}
	     :crux/tx-log {:crux/module 'crux.jdbc/->tx-log
	                   :connection-pool :crux.jdbc/connection-pool
                           :poll-sleep-duration (Duration/ofSeconds 1)}
	     :crux/document-store {:crux/module 'crux.jdbc/->document-store
	                           :connection-pool :crux.jdbc/connection-pool}
             :crux.metrics.csv/reporter {:output-file "metrics.csv"}})

(defonce node (crux/start-node config))

(comment


  (crux/submit-tx node [[:crux.tx/put
                         {:crux.db/id :dbpedia.resource/Pablo-Picasso
                          :first-name "Pablo"
                          :last-name "Picasso"}]])
  ;; => #:crux.tx{:tx-id 2, :tx-time #inst "2021-06-05T10:13:45.256-00:00"}


  (crux/q
   (crux/db node)
   '{:find [p1]
     :where [[p1 :first-name n]]
     :in [name]}
   "Pablo")
  ;; => #{[:dbpedia.resource/Pablo-Picasso]}


  (crux/pull
   (crux/db node)
   [:last-name]
   :dbpedia.resource/Pablo-Picasso)
  ;; => {:last-name "Picasso"}



  (crux/submit-tx node [[:crux.tx/put
                         {:crux.db/id :dbpedia.resource/Pablo-Picasso
                          :last-name "Picazzo"}]])
  ;; => #:crux.tx{:tx-id 4, :tx-time #inst "2021-06-05T10:14:04.772-00:00"}

  (crux/q
   (crux/db node)
   '{:find [(pull ?artist [*])]
     :where [[?artist :crux.db/id :dbpedia.resource/Pablo-Picasso]]})
  ;; => #{[{:crux.db/id :dbpedia.resource/Pablo-Picasso, :last-name "Picazzo"}]}


  )
