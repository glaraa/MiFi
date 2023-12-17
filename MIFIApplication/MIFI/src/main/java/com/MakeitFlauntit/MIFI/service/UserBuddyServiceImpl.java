package com.MakeitFlauntit.MIFI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MakeitFlauntit.MIFI.entity.UserBuddies;
import com.MakeitFlauntit.MIFI.repository.AllUsersRepo;
import com.MakeitFlauntit.MIFI.repository.UserBuddiesRepo;

@Service
public class UserBuddyServiceImpl implements UserBuddyService {
	@Autowired
	  UserBuddiesRepo ubr;
	public void addBuddy(String buddyUserName,String userName) {
		UserBuddies ub=new UserBuddies();
		ub.setBuddyUserName(buddyUserName);
		ub.setUserName(userName);
		ubr.save(ub);
		
	}
}
