package com.administrationrh.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.MultipartFile;

import com.administrationrh.utils.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		property  = "id", 
		scope     = Rapport.class,
		resolver = EntityIdResolver.class,
		generator = ObjectIdGenerators.PropertyGenerator.class)
@Entity
public class Rapport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Date dateCreation;
	
	private String path;
		
	@ManyToOne(fetch=FetchType.LAZY)
	private Fonctionnaire owner;
	

	public Rapport() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Rapport(Long id, String name, Date dateCreation, String path, MultipartFile file, Fonctionnaire owner) {
		super();
		this.id = id;
		this.name = name;
		this.dateCreation = dateCreation;
		this.path = path;
		this.owner = owner;
	}



	public Fonctionnaire getOwner() {
		return owner;
	}

	public void setOwner(Fonctionnaire owner) {
		this.owner = owner;
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
