lazy val akkaHttpVersion = "10.1.3"
lazy val akkaVersion    = "2.5.14"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "com.starwar",
      scalaVersion    := "2.12.4"
    )),
    name := "star-war",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,

      "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion     % Test,
      "org.scalactic" %% "scalactic" % "3.0.5",
      "org.scalatest" %% "scalatest" % "3.0.5" % "test"
    )
  )
