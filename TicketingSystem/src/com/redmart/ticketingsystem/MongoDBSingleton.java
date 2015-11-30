package com.redmart.ticketingsystem;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBSingleton{
	
	private static MongoDBSingleton monngoDBSingleton;
	private static MongoClient mongoclient;
	private static DB db;
	
	private static final String dbHost="localhost";
	private static final int dbPort=27017;
	private static final String dbName="mydb";
	
	private MongoDBSingleton(){
	};
	
	public static MongoDBSingleton getInstance() {
		if(monngoDBSingleton == null) {
			monngoDBSingleton=new MongoDBSingleton();
		}
		return monngoDBSingleton;
	}
	
	public DB getTestDB() {
		if(mongoclient == null) {
			try {
				mongoclient=new MongoClient(dbHost,dbPort);
			} catch(UnknownHostException e) {
				System.out.println(e);
				return null;
			}
		}
		if(db == null) {
			db=mongoclient.getDB(dbName);
		}
		return db;
	}
}
