package com.administrationrh.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administrationrh.domain.Enseignent;
import com.administrationrh.repository.EnseignentRepository;
import com.administrationrh.service.EnseignentService;

@Service
public class EnseignentServiceImpl implements EnseignentService{
	
	@Autowired
	private EnseignentRepository enseignentRepository;

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

}
