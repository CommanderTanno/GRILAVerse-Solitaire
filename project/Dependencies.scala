import sbt._

object Dependencies {
  object Database {
    val jdub = "com.simple" %% "jdub" % "0.9.0" intransitive()
    val postgresJdbc = "org.postgresql" % "postgresql" % "9.4-1200-jdbc41" intransitive()
  }

  object Metrics {
    val jettyServlet = "org.eclipse.jetty" % "jetty-servlet" % "8.1.9.v20130131" withSources()
    val metrics = "nl.grons" %% "metrics-scala" % "3.3.0" withSources() intransitive()
    val metricsJvm = "io.dropwizard.metrics" % "metrics-jvm" % "3.1.0" withSources() intransitive()
    val metricsGraphite = "io.dropwizard.metrics" % "metrics-graphite" % "3.1.0" withSources() intransitive()
    val metricsServlets = "io.dropwizard.metrics" % "metrics-servlets" % "3.1.0" withSources()
  }

  object WebJars {
    val requireJs = "org.webjars" % "requirejs" % "2.1.11-1"
  }
}
