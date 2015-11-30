package com.redmart.ticketingsystem;

import java.util.Set;

import javax.ws.rs.core.Application;

public class ApplicationConfig extends Application{
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources=new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}
	
	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(TicketingSystemRESTWS.class);
	}
}
