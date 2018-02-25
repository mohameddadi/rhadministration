package com.administrationrh.service;

import java.util.List;

import com.administrationrh.domain.Enseignent;
import com.administrationrh.domain.Rapport;

public interface EnseignentService {

	public List<Enseignent> getAllEnseignent();
	
	public List<Enseignent> findEnseignentsByEcole(Long ecoleId);
	
	public Enseignent findEnseignentsById(Long id);
	
	public void addEnseignent(Enseignent enseignent);
	
	public List<Rapport> getEnseignentReports(Long enseignentId);
	
}
