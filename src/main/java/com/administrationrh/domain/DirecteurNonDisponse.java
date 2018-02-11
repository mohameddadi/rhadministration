package com.administrationrh.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.administrationrh.utils.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		property  = "id", 
		scope     = DirecteurNonDisponse.class,
		resolver = EntityIdResolver.class,
		generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
public class DirecteurNonDisponse extends Directeur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private int nbrHouresTeaching;
	
	@ManyToOne( fetch=FetchType.LAZY)
	private Ecole affectedEcole;
	

	public DirecteurNonDisponse() {
		super();
	}

	public DirecteurNonDisponse(Long id, String diploma, String title, Date firstHiringTeaching, Date hiringLocalSchool,
			int seniority, String withinRegularMovement, Ecole ecole, int nbrHouresTeaching, Ecole affectedEcole) {
		super(id, diploma, title, firstHiringTeaching, hiringLocalSchool, seniority, withinRegularMovement, affectedEcole);
		this.nbrHouresTeaching = nbrHouresTeaching;
		this.affectedEcole = affectedEcole;
	}

	public int getNbrHouresTeaching() {
		return nbrHouresTeaching;
	}

	public void setNbrHouresTeaching(int nbrHouresTeaching) {
		this.nbrHouresTeaching = nbrHouresTeaching;
	}

	public Ecole getEcole() {
		return affectedEcole;
	}

	public void setEcole(Ecole ecole) {
		this.affectedEcole = ecole;
	}
	
	

}
