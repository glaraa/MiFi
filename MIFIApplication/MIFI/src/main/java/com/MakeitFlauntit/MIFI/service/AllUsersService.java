package com.MakeitFlauntit.MIFI.service;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MakeitFlauntit.MIFI.entity.AllRecords;
import com.MakeitFlauntit.MIFI.repository.AllUsersRepo;

public interface AllUsersService {

	public AllRecords addUsers(AllRecords allrecords);
	
	public boolean checkUserName(String userName);
	
	public void updateUserAbout(String userName, String changeAbout);
	
	public void updateUserProPic(String userName, String proPic);
	public List<AllRecords> sugUser(String addedUser,Principal p);
	public void feedBack(String userName,String feedback);
	 
}
