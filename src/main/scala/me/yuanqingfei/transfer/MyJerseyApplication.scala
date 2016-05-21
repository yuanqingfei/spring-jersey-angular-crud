package me.yuanqingfei.transfer

import com.alibaba.druid.pool.DruidDataSource
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.{Bean, PropertySource}

/**
  * Created by aaron on 16-5-3.
  */

@SpringBootApplication
@PropertySource(Array("classpath:jdbc.properties"))
class MyJerseyApplication extends SpringBootServletInitializer{

  @Value("${jdbc.url}")
  var jdbcUrl: String = _

  @Value("${jdbc.username}")
  var jdbcUserName: String = _

  @Value("${jdbc.password}")
  var jdbcPassword: String = _

  @Bean
  def druidDataSource: DruidDataSource = {
    val ds: DruidDataSource = new DruidDataSource
    ds.setUrl(jdbcUrl)
    ds.setPassword(jdbcPassword)
    ds.setUsername(jdbcUserName)
    return ds
  }

  override def configure(application: SpringApplicationBuilder): SpringApplicationBuilder = {
    return application.sources(classOf[MyJerseyApplication])
  }

}

object MyLauncher extends App{
  SpringApplication.run(classOf[MyJerseyApplication], args: _*) // bootstrap the application
}
