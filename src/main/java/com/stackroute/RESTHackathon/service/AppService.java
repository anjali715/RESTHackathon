package com.stackroute.RESTHackathon.service;



//Start of Service Interface 
public interface AppService {
	//to get all users
	public Iterable<AppDomain> getAll();
	
	//to get user by id
	public AppDomain getById(int id);
	
	//to add user
	public void add(AppDomain appDomain);
	
	//to update user by id
	public void update(int id, AppDomain appDomain);
	
	//to delete user by id
	public void delete(int id);
	
	//to check if user exists
	public boolean ifExists(int id);

}
//End of Service Interface 