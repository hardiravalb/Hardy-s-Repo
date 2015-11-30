package com.redmart.ticketingsystem;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class TicketDAO{
	
	private String dbCol="ticketingsystem";
	
	public List<Ticket> getAllTickets() {
		MongoDBSingleton dbSingleton=MongoDBSingleton.getInstance();
		DB db=dbSingleton.getTestDB();
		DBCollection coll=db.getCollection(dbCol);
		DBCursor cursor=coll.find().sort(new BasicDBObject("custId",1));
		List<Ticket> list=new ArrayList<Ticket>();
		while(cursor.hasNext()) {
			DBObject o=cursor.next();
			Ticket ticks=new Ticket();
			ticks.setCustId((String)o.get("custId"));
			ticks.setComments((String)o.get("comments"));
			ticks.setCreatedBy((String)o.get("createdBy"));
			ticks.setAssignedTo((String)o.get("assignedTo"));
			ticks.setStatus((String)o.get("status"));
			list.add(ticks);
		}
		return list;
	}
	
	public int deleteTicket(String custId) {
		MongoDBSingleton dbSingleton=MongoDBSingleton.getInstance();
		DB db=dbSingleton.getTestDB();
		DBCollection coll=db.getCollection(dbCol);
		List<Ticket> list=getAllTickets();
		for(Ticket ticks: list) {
			if(ticks.custId.equalsIgnoreCase(custId)) {
				BasicDBObject doc=new BasicDBObject("custId",ticks.custId).append("comments",ticks.comments).append("createdBy",ticks.createdBy).append("assignedTo",ticks.assignedTo)
						.append("status",ticks.status);
				coll.remove(doc);
				return 1;
			}
		}
		return 0;
	}
	
	public Ticket getTicket(String id) {
		List<Ticket> ticks=getAllTickets();
		
		for(Ticket tick: ticks) {
			if(tick.getCustId().equalsIgnoreCase(id)) {
				return tick;
			}
		}
		return null;
	}
	
	public int addTicket(Ticket ticket) {
		MongoDBSingleton dbSingleton=MongoDBSingleton.getInstance();
		DB db=dbSingleton.getTestDB();
		DBCollection coll=db.getCollection(dbCol);
		BasicDBObject doc=new BasicDBObject("custId",ticket.custId).append("comments",ticket.comments).append("createdBy",ticket.createdBy).append("assignedTo",ticket.assignedTo)
				.append("status",ticket.status);
		coll.insert(doc);
		return 1;
	}
	
	public int updateTicket(Ticket ticks) {
		MongoDBSingleton dbSingleton=MongoDBSingleton.getInstance();
		DB db=dbSingleton.getTestDB();
		DBCollection coll=db.getCollection(dbCol);
		List<Ticket> list=getAllTickets();
		for(Ticket tickets: list) {
			if(tickets.custId.equalsIgnoreCase(ticks.custId)) {
				BasicDBObject newdoc=new BasicDBObject("custId",ticks.custId).append("comments",ticks.comments).append("createdBy",ticks.createdBy).append("assignedTo",ticks.assignedTo)
						.append("status",ticks.status);
				BasicDBObject olddoc=new BasicDBObject("custId",tickets.custId).append("comments",tickets.comments).append("createdBy",tickets.createdBy).append("assignedTo",tickets.assignedTo)
						.append("status",tickets.status);
				coll.update(olddoc,newdoc);
				return 1;
			}
		}
		return 0;
	}
	
}
