package com.administrationrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.administrationrh.domain.Rapport;;

public interface RapportRepository extends JpaRepository<Rapport,Long>{

}
