import sbt._

class PocScalatra(info: ProjectInfo) extends DefaultWebProject(info) {
  val javanetRepos = "JavaNet Repository" at "http://download.java.net/maven/2"
  val mavenLocal = "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
  // scalatra
  val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
  val scalatra = "org.scalatra" %% "scalatra" % "2.0.0.M3"


  val guice = "com.google.inject" % "guice" % "3.0"
  val guiceServlet = "com.google.inject.extensions" % "guice-servlet" % "3.0"
  val scalaGuice = "scala-guice" % "scala-guice" % "0.1" from "http://guice-maven.googlecode.com/svn/trunk/scala-guice/scala-guice_2.8.0-0.1.jar"

  val atmosphereRuntime = "org.atmosphere" % "atmosphere-runtime" % "0.7.1"
  val atmosphereGuice = "org.atmosphere" % "atmosphere-guice" % "0.7.1"
  val atmosphereJersey = "org.atmosphere" % "atmosphere-jersey" % "0.7.1"
  val atmosphereAnnotations = "org.atmosphere" % "atmosphere-annotations" % "0.7.1"

  val jerseyJson = "com.sun.jersey" % "jersey-json" % "1.5"
  val jerseyGuice = "com.sun.jersey.contribs" % "jersey-guice" % "1.5"
  val jsr311 = "javax.ws.rs" % "jsr311-api" % "1.1.1"

  // jetty
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.22" % "test"
  val servletApi = "org.mortbay.jetty" % "servlet-api" % "2.5-20081211" % "provided"
}

