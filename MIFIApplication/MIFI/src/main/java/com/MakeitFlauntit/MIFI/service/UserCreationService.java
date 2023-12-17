package com.MakeitFlauntit.MIFI.service;

import org.springframework.stereotype.Service;

import com.MakeitFlauntit.MIFI.entity.AllRecords;
import com.MakeitFlauntit.MIFI.entity.UserCreations;
public interface UserCreationService {

	public UserCreations addCreation(String userName, String creationCaption,String creationName);
}
