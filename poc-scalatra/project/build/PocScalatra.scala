import sbt._

class PocScalatra(info: ProjectInfo) extends DefaultWebProject(info) {
  // scalatra
  val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
  val scalatra = "org.scalatra" %% "scalatra" % "2.0.0.M3"


  val guice = "com.google.inject" % "guice" % "3.0"
  val guiceServlet = "com.google.inject.extensions" % "guice-servlet" % "3.0"
  val scalaGuice = "scala-guice" % "scala-guice" % "0.1" from "http://guice-maven.googlecode.com/svn/trunk/scala-guice/scala-guice_2.8.0-0.1.jar"


  // jetty
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.22" % "test"
  val servletApi = "org.mortbay.jetty" % "servlet-api" % "2.5-20081211" % "provided"
}

