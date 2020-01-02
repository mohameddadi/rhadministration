package com.administrationrh.restweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.administrationrh.config.AuthenticationRequest;
import com.administrationrh.domain.UserTransfer;
import com.administrationrh.service.UserService;
import com.administrationrh.utils.TokenUtil;
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("account")
public class AccountController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
 
	@Autowired
	private UserService customUserDetailsService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value ="/login", method=RequestMethod.POST)
	public ResponseEntity<UserTransfer> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			String username = authenticationRequest.getUsername();
			String password = authenticationRequest.getPassword();
			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authentication = this.authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			List<String> roles = new ArrayList();
 
			for (GrantedAuthority authority : userDetails.getAuthorities()) {
				roles.add(authority.toString());
			}
 
			return new ResponseEntity<UserTransfer>(new UserTransfer(userDetails.getUsername(), roles,
					TokenUtil.createToken(userDetails), HttpStatus.OK), HttpStatus.OK);
 
		} catch (BadCredentialsException bce) {
			return new ResponseEntity<UserTransfer>(new UserTransfer(), HttpStatus.UNPROCESSABLE_ENTITY);
 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
 
	}
 
}
