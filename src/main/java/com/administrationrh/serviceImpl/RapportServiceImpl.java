package com.administrationrh.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administrationrh.domain.Rapport;
import com.administrationrh.repository.RapportRepository;
import com.administrationrh.service.RapportService;

@Service
public class RapportServiceImpl implements RapportService{

	@Autowired
	private RapportRepository rapportRepository;
	
	@Override
	public void addRapport(Rapport rapport) {
		rapportRepository.save(rapport);
		
	}

}
