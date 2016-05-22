name := "spring-jersey-angular-crud"
version := "1.0.0"
scalaVersion := "2.11.8"


val springBootVersion = "1.3.5.RELEASE"
libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-jersey" % springBootVersion,
//  "org.springframework.boot" % "spring-boot-starter-actuator" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
//  "org.springframework.boot" % "spring-boot-starter-tomcat" % springBootVersion % "provided",

  "org.mybatis.spring.boot" % "mybatis-spring-boot-starter" % "1.1.1",
  "com.alibaba" % "druid" % "1.0.15",
  "postgresql" % "postgresql" % "9.1-901.jdbc4"
)

//enablePlugins(TomcatPlugin)
//enablePlugins(WebappPlugin)
mainClass in Compile := Some("me.yuanqingfei.transfer.MyLauncher")

enablePlugins(JavaAppPackaging)
enablePlugins(sbtdocker.DockerPlugin)

dockerfile in docker := {
  val appDir: File = stage.value
  val targetDir = "/app"

  new Dockerfile {
    from("192.168.0.117:5000/java")
    entryPoint(s"$targetDir/bin/${executableScriptName.value}")
    copy(appDir, targetDir)
    expose(8080)
  }
}

//webappResources in package := Seq(baseDirectory.value / "src" / "webapp")

//unmanagedResourceDirectories in Compile += { baseDirectory.value / "src/main/webapp" }
//resourceDirectory in Compile <<= baseDirectory(_ / "src/main/webapp")

//dockerfile in docker := {
//  // The assembly task generates a fat JAR file
//  val artifact: File = assembly.value
//  val artifactTargetPath = s"/app/${artifact.name}"
//
//  new Dockerfile {
//    from("192.168.0.117:5000/java")
//    add(artifact, artifactTargetPath)
//    entryPoint("java", "-jar", artifactTargetPath)
//    expose(8080)
//  }
//}

//mainClass in assembly := Some("me.yuanqingfei.transfer.MyLauncher")
//assemblyJarName in assembly := "crud.jar"
//assemblyMergeStrategy in assembly := {
//  case PathList("META-INF", "spring.provides", xs @ _*)         => MergeStrategy.first
//  case PathList("META-INF", "spring.factories", xs @ _*)         => MergeStrategy.first
//  case PathList("META-INF", "spring-configuration-metadata.json", xs @ _*)         => MergeStrategy.first
//  case PathList("META-INF", "hk2-locator", xs @ _*)         => MergeStrategy.first
//  case PathList("META-INF", "additional-spring-configuration-metadata.json", xs @ _*)         => MergeStrategy.first
//  case PathList("META-INF", "web-fragment.xml", xs @ _*)         => MergeStrategy.first
//
//  case PathList("javax", "annotation", xs @ _*)         => MergeStrategy.first
//  case PathList("org", "aopalliance", xs @ _*)         => MergeStrategy.first
//
//  case x =>
//    val oldStrategy = (assemblyMergeStrategy in assembly).value
//    oldStrategy(x)
//}


