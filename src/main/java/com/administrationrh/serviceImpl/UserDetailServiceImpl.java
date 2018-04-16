package com.administrationrh.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.administrationrh.repository.UserDetailsRepository;
import com.administrationrh.service.UserService;

@Service
public class UserDetailServiceImpl implements UserDetailsService, UserService{

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		com.administrationrh.domain.UserDetails user = userDetailsRepository.findUserByEmail(email);
		
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getId().toString(), user.getPassword(),
				getAuthority());
		
	}

	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
}
