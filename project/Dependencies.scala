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
    val playTest = "com.typesafe.play" %% "play-test" % "2.4.6"
  }

  object Spark {
    val core = "org.apache.spark" %% "spark-core" % "1.4.1" exclude("org.slf4j", "slf4j-log4j12")
  }

  object WebJars {
    val requireJs = "org.webjars" % "requirejs" % "2.1.22"
    val bootstrap = "org.webjars" % "bootstrap" % "3.3.6"
    val underscore = "org.webjars" % "underscorejs" % "1.8.3"
    val d3 = "org.webjars" % "d3js" % "3.5.10"
    val nvd3 = "org.webjars" % "nvd3-community" % "1.7.0"
  }

  object Mail {
    val mailer = "com.typesafe.play" %% "play-mailer" % "3.0.1"
  }

  object Metrics {
    private[this] val version = "3.1.2"
    val jvm = "io.dropwizard.metrics" % "metrics-jvm" % version withSources()
    val ehcache = "io.dropwizard.metrics" % "metrics-ehcache" % version withSources() intransitive()
    val healthChecks = "io.dropwizard.metrics" % "metrics-healthchecks" % version withSources() intransitive()
    val json = "io.dropwizard.metrics" % "metrics-json" % version withSources()
    val servlets = "io.dropwizard.metrics" % "metrics-servlets" % version withSources() intransitive()
    val graphite = "io.dropwizard.metrics" % "metrics-graphite" % version withSources() intransitive()
    val metrics = "nl.grons" %% "metrics-scala" % "3.5.2" withSources()
    val jettyServlet = "org.eclipse.jetty" % "jetty-servlet" % "9.3.6.v20151106" withSources()
  }

  object Akka {
    private[this] val version = "2.4.2"
    val actor = "com.typesafe.akka" %% "akka-actor" % version
    val cluster = "com.typesafe.akka" %% "akka-cluster" % version
    val contrib = "com.typesafe.akka" %% "akka-contrib" % version
    val persistence = "com.typesafe.akka" %% "akka-persistence-experimental" % version
    val remoting = "com.typesafe.akka" %% "akka-remote" % version
    val log4j = "com.typesafe.akka" %% "akka-slf4j" % version
    val testkit = "com.typesafe.akka" %% "akka-testkit" % version
  }

  object Utils {
    private[this] val version = "6.30.0"
    val core = "com.twitter" %% "util-core" % version
    val collection = "com.twitter" %% "util-collection" % version
  }

  object Testing {
    val gatlingCore = "io.gatling" % "gatling-test-framework" % "2.1.7" % "test"
    val gatlingCharts = "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.7" % "test"
  }
}
