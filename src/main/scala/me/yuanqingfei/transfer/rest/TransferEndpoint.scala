package me.yuanqingfei.transfer.rest

import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

import me.yuanqingfei.transfer.pojo.{Transfer, TransferList}
import me.yuanqingfei.transfer.service.TransferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import scala.collection.JavaConversions._

/**
  * Created by aaron on 16-5-21.
  */
@Component
@Path("/api")
class TransferEndpoint @Autowired() (transferService: TransferService) {

  @GET
  @Path("/transfers")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getAll: TransferList = {
      val transferList = new TransferList()
      val orginalList = transferService.getAll()
      transferList.setTotal(orginalList.size())
      transferList.setResults(orginalList)
      transferList
  }

  @GET
  @Path("/transfers2")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getAll2: java.util.List[Transfer] = {
    transferService.getAll()
  }

  @GET
  @Path("/transfers/{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def get(@PathParam("id") id: String): Transfer = {
    transferService.getTransfer(id)
  }

  @POST
  @Path("/transfers")
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @Produces(Array(MediaType.APPLICATION_JSON))
  def insert(transfer: Transfer): Transfer = {
    transferService.insertTransfer(transfer)
  }

  @POST
  @Path("/transfers/{id}")
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @Produces(Array(MediaType.APPLICATION_JSON))
  def insert2(@PathParam("id") id: String, transfer: Transfer): Transfer = {
    transferService.insertTransfer(transfer)
  }

  @PUT
  @Path("/transfers/{id}")
  @Consumes(Array(MediaType.APPLICATION_JSON))
  def update(@PathParam("id") id: String, transfer: Transfer): Transfer = {
    transferService.updateTransfer(id, transfer)
  }

  @DELETE
  @Path("/transfers/{id}")
  def delete(@PathParam("id") id: String): Response = {
    transferService.deleteTransfer(id)
    Response.ok("delete successfully!").build();
  }

}


