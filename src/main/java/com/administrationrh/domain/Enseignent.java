package com.administrationrh.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Enseignent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private Date hiringDate;
	
	private String titre;
	
	private int NbrWorkedHoures;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Ecole ecole;
	
	private String phone;
	
	private String uniqueIdentier;
	
	private String birthday;
	
	private int numberOfChildren;
	
	private String familySituation;
	
	public Enseignent() {
	}


	public Enseignent(Long id, String name, String lastName, Date hiringDate, String titre, int nbrWorkedHoures,
			Ecole ecole, String phone, String uniqueIdentier, String birthday, int numberOfChildren,
			String familySituation) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.hiringDate = hiringDate;
		this.titre = titre;
		NbrWorkedHoures = nbrWorkedHoures;
		this.ecole = ecole;
		this.phone = phone;
		this.uniqueIdentier = uniqueIdentier;
		this.birthday = birthday;
		this.numberOfChildren = numberOfChildren;
		this.familySituation = familySituation;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUniqueIdentier() {
		return uniqueIdentier;
	}

	public void setUniqueIdentier(String uniqueIdentier) {
		this.uniqueIdentier = uniqueIdentier;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public String getFamilySituation() {
		return familySituation;
	}

	public void setFamilySituation(String familySituation) {
		this.familySituation = familySituation;
	}
	
	
}
