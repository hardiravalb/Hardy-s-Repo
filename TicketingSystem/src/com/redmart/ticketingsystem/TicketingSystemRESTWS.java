package com.redmart.ticketingsystem;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ticket")
public class TicketingSystemRESTWS{
	
	TicketDAO ticketdao=new TicketDAO();
	
	// The below method works with URI
	@GET
	@Path("/get/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket getTicket(@PathParam("custId") String custId) {
		return ticketdao.getTicket(custId);
	}
	
	// The below method works with URI
	@GET
	@Path("/getTickets")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> getTickets() {
		return ticketdao.getAllTickets();
		
	}
	
	// The below method works with URI
	@GET
	@Path("/insert/{custId}/{comments}/{createdBy}/{assignedTo}/{status}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket insert(@PathParam("custId") String custId,@PathParam("comments") String comments,@PathParam("createdBy") String createdBy,@PathParam("assignedTo") String assignedTo,
			@PathParam("status") String status) {
		Ticket ticks=new Ticket(custId,comments,createdBy,assignedTo,status);
		int result=ticketdao.addTicket(ticks);
		if(result == 1) {
			return ticks;
		}
		return null;
	}
	
	// The below method works with Form
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Ticket addticket(Ticket tick) {
		Ticket ticks=new Ticket(tick.custId,tick.comments,tick.createdBy,tick.assignedTo,tick.status);
		int result=ticketdao.addTicket(ticks);
		if(result == 1) {
			return ticks;
		}
		return null;
	}
	
	// The below method works with URI
	@GET
	@Path("/update/{custId}/{comments}/{createdBy}/{assignedTo}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public String update(@PathParam("custId") String custId,@PathParam("comments") String comments,@PathParam("createdBy") String createdBy,@PathParam("assignedTo") String assignedTo,
			@PathParam("status") String status) {
		Ticket ticket=new Ticket(custId,comments,createdBy,assignedTo,status);
		int result=ticketdao.updateTicket(ticket);
		if(result == 1) {
			return "Ticket updated successfully";
		}
		return "There was some issue while updating the ticket";
	}
	
	// The below method works with Form
	@PUT
	@Path("/updatetick")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateTicket(Ticket tick) {
		Ticket ticket=new Ticket(tick.custId,tick.comments,tick.createdBy,tick.assignedTo,tick.status);
		int result=ticketdao.updateTicket(ticket);
		if(result == 1) {
			return "Ticket updated successfully";
		}
		return "There was some issue while updating the ticket";
	}
	
	// The below method works with URI
	@GET
	@Path("/delete/{custId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@PathParam("custId") String custId) {
		int result=ticketdao.deleteTicket(custId);
		if(result == 1) {
			return "ticket deleted successfully";
		}
		return "ticket not deleted successfully";
	}
	
	// The below method works with Form
	@DELETE
	@Path("/deletetick/{custId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteTicket(@PathParam("custId") String custId) {
		int result=ticketdao.deleteTicket(custId);
		if(result == 1) {
			return Response.status(200).entity("Deleted successfully").build();
		}
		return Response.status(200).entity("not Deleted successfully").build();
	}
	
}
