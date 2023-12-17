package com.MakeitFlauntit.MIFI.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MakeitFlauntit.MIFI.entity.AllRecords;
import com.MakeitFlauntit.MIFI.entity.BuddyReqs;
import com.MakeitFlauntit.MIFI.repository.AllUsersRepo;
import com.MakeitFlauntit.MIFI.repository.BuddyReqsRepo;

@Service
public class BuddyReqServiceImpl implements BuddyReqService {
	@Autowired
	BuddyReqsRepo brr;
	@Autowired
	AllUsersRepo aur;
	public void addBuddyReqs(String addedUserName,String reqUserName){
		{
			BuddyReqs br=new BuddyReqs();
			br.setReqUserName(reqUserName);
			br.setAddedUserName(addedUserName);
			brr.save(br);
			 System.out.println(br);
		}
	}
	@Override
	public List<AllRecords> showBudReqs(String addedUserName) {
		List<AllRecords> userReqsDetails= new ArrayList<AllRecords>();
		List <String> userReqs=brr.findByAddedUserName(addedUserName);
		if(!userReqs.isEmpty()) {
		for(String ur :userReqs ) {
			userReqsDetails.addAll(aur.findAllByUserName(ur));
		}
		}
		return userReqsDetails;
	}
}
