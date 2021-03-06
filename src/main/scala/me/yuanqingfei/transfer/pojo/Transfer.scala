package me.yuanqingfei.transfer.pojo

import javax.ws.rs.client.Entity

import scala.beans.BeanProperty

/**
  * Created by aaron on 16-5-21.
  */
class Transfer {

  @BeanProperty
  var id: String = _

  @BeanProperty
  var doctor: String = _

  @BeanProperty
  var sender: String = _

  @BeanProperty
  var receiver: String = _

  override def toString = s"Transfer($id, $doctor, $sender, $receiver)"
}
