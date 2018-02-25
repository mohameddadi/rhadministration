package com.administrationrh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.administrationrh.domain.Rapport;;

public interface RapportRepository extends JpaRepository<Rapport,Long>{

	public List<Rapport> findAllByOwnerId(Long enseignentId);
}
