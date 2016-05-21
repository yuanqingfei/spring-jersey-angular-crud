package me.yuanqingfei.transfer.rest

import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.servlet.ServletProperties
import org.springframework.stereotype.Component

/**
  * Created by aaron on 16-5-21.
  */
@Component
class JerseyConfig extends ResourceConfig{
    register(classOf[TransferEndpoint])
    property(ServletProperties.FILTER_FORWARD_ON_404, true)
}
