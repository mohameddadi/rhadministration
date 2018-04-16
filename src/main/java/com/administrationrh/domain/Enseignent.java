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
		scope     = Enseignent.class,
		resolver = EntityIdResolver.class,
		generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
public class Enseignent extends Fonctionnaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int NbrWorkedHoures;
	
	@ManyToOne(fetch=FetchType.LAZY)
	protected Ecole ecole;
	
	public Enseignent() {
	}

	public Enseignent(Long id, String name, String lastName, Date hiringDate, String titre, String phone,
			String uniqueIdentier, String birthday, int numberOfChildren, String familySituation, int nbrWorkedHoures,
			Ecole ecole) {
		super(id, name, lastName, hiringDate, titre, phone, uniqueIdentier, birthday, numberOfChildren,
				familySituation);
		NbrWorkedHoures = nbrWorkedHoures;
		this.ecole = ecole;
	}



	public Long getId() {
		return super.getId();
	}

	public void setId(Long id) {
		super.setId(id);
	}


	public int getNbrWorkedHoures() {
		return NbrWorkedHoures;
	}


	public void setNbrWorkedHoures(int nbrWorkedHoures) {
		NbrWorkedHoures = nbrWorkedHoures;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
}
