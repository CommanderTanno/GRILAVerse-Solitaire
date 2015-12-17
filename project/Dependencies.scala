import sbt._

object Dependencies {
  object Cache {
    val ehCache = "net.sf.ehcache" % "ehcache-core" % "2.6.11"
  }

  object Database {
    val postgresAsync = "com.github.mauricio" %% "postgresql-async" % "0.2.18"
    val reactiveMongo = "org.reactivemongo" %% "reactivemongo" % "0.11.6"
    val playMongo = "org.reactivemongo" %% "play2-reactivemongo" % "0.11.6.play24"
    val graph = "com.assembla.scala-incubator" %% "graph-core" % "1.9.4"
  }

  object Play {
    val playFilters = play.sbt.PlayImport.filters
    val playWs = play.sbt.PlayImport.ws
    val playJson = play.sbt.PlayImport.json
    val playTest = "com.typesafe.play" %% "play-test" % "2.4.3"
  }

  object Spark {
    val core = "org.apache.spark" %% "spark-core" % "1.4.1" exclude("org.slf4j", "slf4j-log4j12")
  }

  object WebJars {
    val requireJs = "org.webjars" % "requirejs" % "2.1.20"
    val bootstrap = "org.webjars" % "bootstrap" % "3.3.5"
    val underscore = "org.webjars" % "underscorejs" % "1.8.3"
    val d3 = "org.webjars" % "d3js" % "3.5.6"
    val nvd3 = "org.webjars" % "nvd3-community" % "1.7.0"
  }

  object Mail {
    val mailer = "com.typesafe.play" %% "play-mailer" % "3.0.1"
  }

  object Authentication {
    val silhouette = "com.mohiva" %% "play-silhouette" % "3.0.4"
  }

  object Metrics {
    val metrics = "nl.grons" %% "metrics-scala" % "3.5.2" withSources()
    val jvm = "io.dropwizard.metrics" % "metrics-jvm" % "3.1.2" withSources()
    val ehcache = "io.dropwizard.metrics" % "metrics-ehcache" % "3.1.2" withSources() intransitive()
    val healthChecks = "io.dropwizard.metrics" % "metrics-healthchecks" % "3.1.2" withSources() intransitive()

    val json = "io.dropwizard.metrics" % "metrics-json" % "3.1.2" withSources()

    val jettyServlet = "org.eclipse.jetty" % "jetty-servlet" % "9.3.4.v20151007" withSources()
    val servlets = "io.dropwizard.metrics" % "metrics-servlets" % "3.1.2" withSources() intransitive()
    val graphite = "io.dropwizard.metrics" % "metrics-graphite" % "3.1.2" withSources() intransitive()
  }

  object Akka {
    val actor = "com.typesafe.akka" %% "akka-actor" % "2.4.0"
    val cluster = "com.typesafe.akka" %% "akka-cluster" % "2.4.0"
    val contrib = "com.typesafe.akka" %% "akka-contrib" % "2.4.0"
    val persistence = "com.typesafe.akka" %% "akka-persistence-experimental" % "2.4.0"
    val remoting = "com.typesafe.akka" %% "akka-remote" % "2.4.0"
    val log4j = "com.typesafe.akka" %% "akka-slf4j" % "2.4.0"
  }

  object Utils {
    val core = "com.twitter" %% "util-core" % "6.28.0"
    val collection = "com.twitter" %% "util-collection" % "6.28.0"
  }

  object Testing {
    val testkit = "com.typesafe.akka" %% "akka-testkit" % "2.4.0"
    val gatlingCore = "io.gatling" % "gatling-test-framework" % "2.1.7" % "test"
    val gatlingCharts = "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.7" % "test"
  }
}
