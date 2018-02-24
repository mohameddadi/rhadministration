package com.administrationrh.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.administrationrh.utils.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		property  = "id", 
		scope     = Directeur.class,
		resolver = EntityIdResolver.class,
		generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Fonctionnaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	protected String name;
	
	protected String lastName;
	
	protected Date hiringDate;
	
	protected String titre;
	
	protected String phone;
	
	protected String uniqueIdentier;
	
	protected String birthday;
	
	protected int numberOfChildren;
	
	protected String familySituation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "owner", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	protected Set<Rapport> reports;
	

	public Fonctionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fonctionnaire(Long id, String name, String lastName, Date hiringDate, String titre, String phone,
			String uniqueIdentier, String birthday, int numberOfChildren, String familySituation) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.hiringDate = hiringDate;
		this.titre = titre;
		this.phone = phone;
		this.uniqueIdentier = uniqueIdentier;
		this.birthday = birthday;
		this.numberOfChildren = numberOfChildren;
		this.familySituation = familySituation;
	}
	

	public Fonctionnaire(Long id, String name, String lastName, Date hiringDate, String titre, String phone,
			String uniqueIdentier, String birthday, int numberOfChildren, String familySituation,
			Set<Rapport> reports) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.hiringDate = hiringDate;
		this.titre = titre;
		this.phone = phone;
		this.uniqueIdentier = uniqueIdentier;
		this.birthday = birthday;
		this.numberOfChildren = numberOfChildren;
		this.familySituation = familySituation;
		this.reports = reports;
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

	public Set<Rapport> getReports() {
		return reports;
	}

	public void setReports(Set<Rapport> reports) {
		this.reports = reports;
	}
	
}
