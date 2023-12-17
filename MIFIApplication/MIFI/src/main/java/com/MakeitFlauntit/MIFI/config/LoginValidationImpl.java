package com.MakeitFlauntit.MIFI.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.MakeitFlauntit.MIFI.entity.AllRecords;
import com.MakeitFlauntit.MIFI.repository.AllUsersRepo;
@Service
public class LoginValidationImpl implements UserDetailsService{
	@Autowired
	private AllUsersRepo aur;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AllRecords allrecords = aur.findByUserName(username);
		//System.out.println(allrecords);
		
		if (allrecords != null) {
			return new LoginValidation(allrecords);
		}

		throw new UsernameNotFoundException("user not available");
	}

}
