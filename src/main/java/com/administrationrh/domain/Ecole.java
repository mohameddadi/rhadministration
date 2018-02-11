package com.administrationrh.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.administrationrh.utils.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		property  = "id", 
		scope     = Ecole.class,
		resolver = EntityIdResolver.class,
		generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
public class Ecole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String Name;
	
	private String type;
	
	private String priority;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ecole", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Enseignent> enseignents;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ecole",  fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Directeur> directeurs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "affectedEcole",  fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<DirecteurNonDisponse> directeursNonDisponses;
	
	

	public Ecole() {
		super();
	}

	public Ecole(Long id, String name, String type, String priority) {
		super();
		this.id = id;
		Name = name;
		this.type = type;
		this.priority = priority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Set<Enseignent> getEnseignents() {
		return enseignents;
	}

	public void setEnseignents(Set<Enseignent> enseignents) {
		this.enseignents = enseignents;
	}

	public Set<Directeur> getDirecteurs() {
		return directeurs;
	}

	public void setDirecteurs(Set<Directeur> directeurs) {
		this.directeurs = directeurs;
	}

	public Set<DirecteurNonDisponse> getDirecteursNonDisponses() {
		return directeursNonDisponses;
	}

	public void setDirecteursNonDisponses(Set<DirecteurNonDisponse> directeursNonDisponses) {
		this.directeursNonDisponses = directeursNonDisponses;
	}
	
	
}
