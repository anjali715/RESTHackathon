package com.stackroute.RESTHackathon.service;

import com.stackroute.RESTHackathon.domain.AppDomain;
import com.stackroute.RESTHackathon.repository.AppRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Start of Service
@Service
public class AppServiceDaoImpl implements AppService {

	private AppRepository appRepository;
	
	//to get all users
	public Iterable<AppDomain> getAll() {

		return appRepository.findAll();
	}

	
	//getter function for repository
	public AppRepository getAppRepository() {
		return appRepository;
	}

	//setter function for repository
	@Autowired
	public void setAppRepository(AppRepository appRepository) {
		this.appRepository = appRepository;
	}

	//to find user by id
	public AppDomain getById(int id) {

		return appRepository.findById(id);
	}

	//to add user
	public void add(AppDomain appDomain) {
		appRepository.save(appDomain);

	}

	//to update user by id
	public void update(int id, AppDomain appDomain) {

		appRepository.save(appDomain);

	}

	//to delete user by id
	public void delete(int id) {
		appRepository.delete(id);

	}

	//to check if user exists in database
	public boolean ifExists(int id) {
		if (appRepository.findOne(id) != null)
			return true;
		else
			return false;
	}

	//regex for email validation
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	//function for email validation
	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

}

//End of interface
