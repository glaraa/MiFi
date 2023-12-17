package com.MakeitFlauntit.MIFI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MakeitFlauntit.MIFI.entity.AllRecords;

@Service
public interface BuddyReqService {
	
  public void addBuddyReqs(String userName,String reqUserName);
  
  public List<AllRecords> showBudReqs(String addedUserName);
  
}
