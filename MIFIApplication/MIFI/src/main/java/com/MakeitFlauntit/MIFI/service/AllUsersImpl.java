package com.MakeitFlauntit.MIFI.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.MakeitFlauntit.MIFI.entity.AllRecords;
import com.MakeitFlauntit.MIFI.entity.FeedBack;
import com.MakeitFlauntit.MIFI.repository.AllUsersRepo;
import com.MakeitFlauntit.MIFI.repository.FeedbackRepo;

@Service
public class AllUsersImpl implements AllUsersService{
	@Autowired
  AllUsersRepo aur;
	@Autowired
	  FeedbackRepo fbr;
 @Autowired
	private BCryptPasswordEncoder passwordEncode;
	@Override
	public AllRecords addUsers(AllRecords allrecords) {
	 	allrecords.setPassword(passwordEncode.encode(allrecords.getPassword()));
	 	allrecords.setRole("ROLE_USER");
	 	allrecords.setUserProPic("ProfilePic.png");
	 	allrecords.setUserAbout("Welcome To MiFi...!Flaunt your creations Here..");
		return aur.save(allrecords);
	}

	@Override
	public boolean checkUserName(String userName) {
		return aur.existsByUserName(userName);
	}
	
	public void updateUserAbout(String userName, String changeAbout) {
		AllRecords allrecords = aur.findByUserName(userName);
		allrecords.setUserAbout(changeAbout);
		aur.save(allrecords);
	}
	public void updateUserProPic(String userName, String proPic) {
		AllRecords allrecords = aur.findByUserName(userName);
		allrecords.setUserProPic(proPic);
		aur.save(allrecords);
	}

	@Override
	public List<AllRecords> sugUser(String addedUser,Principal p) {
		
		return null;
		
	}

	@Override
	public void feedBack(String userName, String feedback) {
		FeedBack fb=new FeedBack();
		fb.setUserName(userName);
		fb.setUserfb(feedback);
		fbr.save(fb);
		
	}


}
