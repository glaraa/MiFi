package com.MakeitFlauntit.MIFI.config;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.MakeitFlauntit.MIFI.entity.AllRecords;

public class LoginValidation implements UserDetails {

	private AllRecords allrecords;
	
	public LoginValidation(AllRecords allrecords) {
		super();
		this.allrecords = allrecords;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(allrecords.getRole());
		return Arrays.asList(simpleGrantedAuthority);
	}
	
	@Override
	public String getPassword() {
		return allrecords.getPassword();
	}

	@Override
	public String getUsername() {
		return allrecords.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
