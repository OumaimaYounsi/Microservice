package com.esprit.microservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author NADA_USER
 *
 */
/**
 * @author NADA_USER
 *
 */
@Entity
public class Electeur implements Serializable{
	private static final long serialVersionUID = 6;
	
	@Id
	@GeneratedValue
	private int id;
	private String nom, prenom, numCin;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return numCin;
	}
	public void setEmail(String numCin) {
		this.numCin = numCin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Electeur() {
		super();
	}
	public Electeur(String nom) {
		super();
		this.nom = nom;
	}
	
	public Electeur(int id) {
		super();
		this.id = id;
	}
	
	public Electeur(int id, String nom, String prenom, String numCin) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numCin = numCin;
	}
	
	
	
	
	
	

	
	
	
	
	
	
}
