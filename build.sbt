name := "spring-jersey-angular-crud"
version := "1.0.0"
scalaVersion := "2.11.8"


val springBootVersion = "1.3.5.RELEASE"
libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-jersey" % springBootVersion ,

  "org.mybatis.spring.boot" % "mybatis-spring-boot-starter" % "1.1.1",
  "com.alibaba" % "druid" % "1.0.15",
  "postgresql" % "postgresql" % "9.1-901.jdbc4"
)

enablePlugins(TomcatPlugin)
//containerPort := 9090

containerLibs in Tomcat := Seq("com.github.jsimone" % "webapp-runner" % "8.0.33.0" intransitive())
//containerMain in Tomcat := "webapp.runner.launch.Main"

enablePlugins(sbtdocker.DockerPlugin)

docker <<= docker.dependsOn(webappPrepare)

dockerfile in docker := {
//  target in webappPrepare := target.value / "WebContent"
  val webDir: File = target.value / "webapp"

  new Dockerfile {
    from("192.168.0.117:5000/tomcat:8.0-jre8")
    run("rm", "-rf", "/usr/local/tomcat/webapps/ROOT")
    copy(webDir, "/usr/local/tomcat/webapps/ROOT")
    //copyRaw("target/webapp", "/var/lib/jetty/webapps/ROOT") //for jetty
    expose(8080)
  }
}



