package com.administrationrh.restweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.administrationrh.domain.Enseignent;
import com.administrationrh.service.EnseignentService;

@RestController
public class EnseignentRestController {
	
	@Autowired
	private EnseignentService enseignentService;

	@RequestMapping(value = "/enseignents/", method = RequestMethod.GET)
	@ResponseBody public List<Enseignent> getAllEnseignents(){
		return enseignentService.getAllEnseignent();
	}
	
	@RequestMapping(value = "/enseignentsByEcole/{ecoleId}", method = RequestMethod.GET)
	@ResponseBody public List<Enseignent> findEnseignentsByEcole(@PathVariable("ecoleId") Long ecoleId){
		return enseignentService.findEnseignentsByEcole(ecoleId);
	}
	
	@RequestMapping(value = "/enseignent/{id}", method = RequestMethod.GET)
	@ResponseBody public Enseignent findEnseignentById(@PathVariable("id") Long id){
		return enseignentService.findEnseignentsById(id);
	}
}
