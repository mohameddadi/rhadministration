package com.administrationrh.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administrationrh.domain.Enseignent;
import com.administrationrh.domain.Rapport;
import com.administrationrh.repository.EnseignentRepository;
import com.administrationrh.repository.RapportRepository;
import com.administrationrh.service.EnseignentService;

@Service
public class EnseignentServiceImpl implements EnseignentService{
	
	@Autowired
	private EnseignentRepository enseignentRepository;
	
	@Autowired
	private RapportRepository rapportRepository;

	@Override
	public List<Enseignent> getAllEnseignent() {
		
		return enseignentRepository.findAll();
	}

	@Override
	public List<Enseignent> findEnseignentsByEcole(Long ecoleId) {
		
		return  enseignentRepository.findEnseignentsByEcole(ecoleId);
	}

	@Override
	public Enseignent findEnseignentsById(Long id) {
		// TODO Auto-generated method stub
		return enseignentRepository.findOne(id);
	}

	@Override
	public void addEnseignent(Enseignent enseignent) {
		enseignentRepository.save(enseignent);
	}

	@Override
	public List<Rapport> getEnseignentReports(Long enseignentId) {
		// TODO Auto-generated method stub
		return rapportRepository.findAllByOwnerId(enseignentId);
	}

}
