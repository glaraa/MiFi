package com.MakeitFlauntit.MIFI.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.MakeitFlauntit.MIFI.entity.AllRecords;
import com.MakeitFlauntit.MIFI.entity.UserCreations;
import com.MakeitFlauntit.MIFI.repository.AllUsersRepo;
import com.MakeitFlauntit.MIFI.repository.UserCreationsRepo;
@Service
public class UserCreationImpl implements UserCreationService {
    @Autowired
	AllUsersRepo aur;
    @Autowired
	UserCreationsRepo ucr;
	
	@Override
	public UserCreations addCreation(String userName, String creationCaption,String creationName) {
		   UserCreations uc =new UserCreations();
		   AllRecords ar= new AllRecords();
		   ar=aur.findByUserName(userName);
		   uc.setFirstName(ar.getFirstName());
		   uc.setLastName(ar.getLastName());
		   uc.setProPic(ar.getUserProPic());
		   uc.setCaption(creationCaption);
		   uc.setCreation(creationName);
		   uc.setUserName(userName);
		   uc.setCreationDate(LocalDate.now());
		   return ucr.save(uc);
	}
	

}
