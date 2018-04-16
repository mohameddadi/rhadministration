package com.administrationrh.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administrationrh.domain.Ecole;
import com.administrationrh.repository.EcoleRepository;
import com.administrationrh.service.EcoleService;

@Service
public class EcoleServiceImpl implements EcoleService{

	@Autowired
	private EcoleRepository ecoleRepository;
	@Override
	public void addEcole(Ecole ecole) {
		ecoleRepository.saveAndFlush(ecole);
	}

}
