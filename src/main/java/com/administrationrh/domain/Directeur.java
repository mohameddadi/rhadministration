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
		scope     = Directeur.class,
		resolver = EntityIdResolver.class,
		generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
public class Directeur extends Fonctionnaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String diploma;
		
	private Date firstHiringTeaching;
	
	private Date hiringLocalSchool;
	
	private int seniority;
	
	private String withinRegularMovement;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Ecole ecole;
	
	public Directeur() {
		super();
	}

	public Directeur(Long id, String diploma, String title, Date firstHiringTeaching, Date hiringLocalSchool,
			int seniority, String withinRegularMovement, Ecole ecole) {
		super();
		this.diploma = diploma;
		this.firstHiringTeaching = firstHiringTeaching;
		this.hiringLocalSchool = hiringLocalSchool;
		this.seniority = seniority;
		this.withinRegularMovement = withinRegularMovement;
		this.ecole = ecole;
	}

	public String getDiploma() {
		return diploma;
	}

	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	public Date getFirstHiringTeaching() {
		return firstHiringTeaching;
	}

	public void setFirstHiringTeaching(Date firstHiringTeaching) {
		this.firstHiringTeaching = firstHiringTeaching;
	}

	public Date getHiringLocalSchool() {
		return hiringLocalSchool;
	}

	public void setHiringLocalSchool(Date hiringLocalSchool) {
		this.hiringLocalSchool = hiringLocalSchool;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public String getWithinRegularMovement() {
		return withinRegularMovement;
	}

	public void setWithinRegularMovement(String withinRegularMovement) {
		this.withinRegularMovement = withinRegularMovement;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
}
