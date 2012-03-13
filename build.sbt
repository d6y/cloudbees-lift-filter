name := "Cloudbees Lift Filter"
 
scalaVersion := "2.9.1"
 
seq(webSettings :_*)

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies ++= {
  val liftVersion = "2.4" 
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default"
  )
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
 "org.mortbay.jetty" % "jetty" % "6.1.22" % "container",
  "org.scala-tools.testing" % "specs_2.9.0" % "1.6.8" % "test", // For specs.org tests
  "junit" % "junit" % "4.8" % "test->default", // For JUnit 4 testing
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "ch.qos.logback" % "logback-classic" % "0.9.29" % "compile->default" // Logging
)


