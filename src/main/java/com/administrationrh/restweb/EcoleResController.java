package com.administrationrh.restweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.administrationrh.domain.Ecole;
import com.administrationrh.service.EcoleService;

@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class EcoleResController {

	@Autowired
	private EcoleService ecoleService;
	
	@RequestMapping(value="/ecole/", method=RequestMethod.PUT)
	public ResponseEntity<?> addEnseignent(@RequestBody Ecole ecole){
		ecoleService.addEcole(ecole);
        return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
