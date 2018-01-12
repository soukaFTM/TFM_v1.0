package org.TFM.Clients.Entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.TFM.Commande.Entities.Commande;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Entity 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Enfant implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeEnfant;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	
	
	@ManyToMany
	@JoinTable(
			name = "EnfantCommande", 
			joinColumns = @JoinColumn(name = "codeEnfant"),
			inverseJoinColumns = @JoinColumn(name = "codeCommande"))
	private Collection<Commande> ListCommande;
	
	
	public Enfant() {
		super();
		// TODO Auto-generated constructor stub
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public long getCodeEnfant() {
		return codeEnfant;
	}
	public void setCodeEnfant(long codeEnfant) {
		this.codeEnfant = codeEnfant;
	}
	@JsonIgnore
	public Collection<Commande> getListCommande() {
		return ListCommande;
	}
	public void setListCommande(Collection<Commande> listCommande) {
		ListCommande = listCommande;
	}

	
}
