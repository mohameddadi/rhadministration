package com.administrationrh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.administrationrh.domain.Enseignent;

public interface EnseignentRepository extends JpaRepository<Enseignent,Long>{

	@Query("SELECT e from Enseignent e INNER JOIN FETCH e.ecole where e.ecole.id = :ecoleId")
	List<Enseignent> findEnseignentsByEcole(@Param("ecoleId") Long ecoleId);

}
