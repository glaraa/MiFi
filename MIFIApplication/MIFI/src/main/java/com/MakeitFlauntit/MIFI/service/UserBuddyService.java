package com.MakeitFlauntit.MIFI.service;
import org.springframework.stereotype.Service;

@Service
public interface UserBuddyService {

	public void addBuddy(String buddyUserName,String userName);
	
}
