package org.TFM.Clients.Entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("PHY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ClientPhysique extends Client implements Serializable{
	private String CIN;
	private String nom;
	private String prenom;
	public ClientPhysique() {
		super();
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
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
	
	
	
}
