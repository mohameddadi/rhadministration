package com.administrationrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.administrationrh.domain.Ecole;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole,Long>{

	
}
