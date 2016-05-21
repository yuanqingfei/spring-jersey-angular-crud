package me.yuanqingfei.transfer.rest

import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import me.yuanqingfei.transfer.pojo.Transfer
import me.yuanqingfei.transfer.service.TransferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import scala.collection.JavaConversions._

/**
  * Created by aaron on 16-5-21.
  */
@Component
@Path("/transfers")
class TransferEndpoint @Autowired() (transferService: TransferService) {

  @GET
  @Path("/")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getAll: java.util.List[Transfer] = {
      transferService.getAll()
  }

  @GET
  @Path("/{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def get(@PathParam("id") id: String): Transfer = {
    transferService.getTransfer(id)
  }

  @POST
  @Path("/")
  @Consumes(Array(MediaType.APPLICATION_JSON))
  def insert(transfer: Transfer): Response = {
    transferService.insertTransfer(transfer)
    Response.ok("insert successfully!").build();
  }

  @PUT
  @Path("/{id}")
  @Consumes(Array(MediaType.APPLICATION_JSON))
  def update(@PathParam("id") id: String, transfer: Transfer): Response = {
    transferService.updateTransfer(id, transfer)
    Response.ok("update successfully!").build();
  }

  @DELETE
  @Path("/{id}")
  def delete(@PathParam("id") id: String): Response = {
    transferService.deleteTransfer(id)
    Response.ok("delete successfully!").build();
  }

}
