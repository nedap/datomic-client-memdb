(defproject com.nedap.staffing-solutions/datomic-client-memdb "0.4.0-alpha4"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.datomic/client "0.8.69"]
                 [com.datomic/datomic-free "0.9.5697"]]

  :min-lein-version "2.0.0"

  :signing {:gpg-key "releases-staffingsolutions@nedap.com"}

  :repositories {"releases" {:url      "https://nedap.jfrog.io/nedap/staffing-solutions/"
                             :username :env/artifactory_user
                             :password :env/artifactory_pass}}

  :deploy-repositories [["releases" {:url "https://nedap.jfrog.io/nedap/staffing-solutions/"}]]

  :repository-auth {#"https://nedap.jfrog\.io/nedap/staffing-solutions/"
                    {:username :env/artifactory_user
                     :password :env/artifactory_pass}}

  :target-path "target/%s"

  :monkeypatch-clojure-test false

  :plugins [[lein-pprint "1.1.2"]]

  :profiles {:ci       {:pedantic?    :abort
                        :jvm-opts     ["-Dclojure.main.report=stderr" "-Dnedap.ci.release-workflow.stable-branches=release"]
                        :global-vars  {*assert* true} ;; `ci.release-workflow` relies on runtime assertions
                        :dependencies [[com.nedap.staffing-solutions/ci.release-workflow "1.2.0"]]}})
