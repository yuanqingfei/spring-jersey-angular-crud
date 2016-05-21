name := "spring-jersey-angular-crud"
version := "1.0.0"
scalaVersion := "2.11.8"


val springBootVersion = "1.3.5.RELEASE"
libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-jersey" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-actuator" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-tomcat" % springBootVersion % "provided",

  "org.mybatis.spring.boot" % "mybatis-spring-boot-starter" % "1.1.1",
  "com.alibaba" % "druid" % "1.0.15",
  "postgresql" % "postgresql" % "9.1-901.jdbc4"
)

//enablePlugins(TomcatPlugin)
mainClass in Compile := Some("me.yuanqingfei.transfer.MyLauncher")
