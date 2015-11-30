package com.redmart.ticketingsystem;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="ticket")
public class Ticket implements Serializable{
	
	String custId;
	String comments;
	String createdBy;
	String assignedTo;
	String status;
	
	@XmlElement(required=true)
	public String getCustId() {
		return custId;
	}
	
	public void setCustId(String custId) {
		this.custId=custId;
	}
	
	@XmlElement
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments=comments;
	}
	
	@XmlElement(required=true)
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy=createdBy;
	}
	
	@XmlElement(required=true)
	public String getAssignedTo() {
		return assignedTo;
	}
	
	public void setAssignedTo(String assignedTo) {
		this.assignedTo=assignedTo;
	}
	
	@XmlElement(required=true)
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}
	
	public Ticket(String custId,String comments,String createdBy,String assignedTo,String status){
		super();
		this.custId=custId;
		this.comments=comments;
		this.createdBy=createdBy;
		this.assignedTo=assignedTo;
		this.status=status;
	}
	
	public Ticket(){
		super();
	}
	
}
