package org.TFM.Commande.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.TFM.Clients.Entities.Enfant;
import org.TFM.Programe.Entities.Programme;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Commande implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeCommande;
	private double totale;
	
	@ManyToMany(mappedBy = "ListCommande",fetch = FetchType.LAZY)
	private Collection<Enfant> ListEnfant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CodeProgramme")
	private Programme programme = new Programme();
	
	private Boolean paiement = false;
	
	
	
	public Boolean getPaiement() {
		return paiement;
	}
	public void setPaiement(Boolean paiement) {
		this.paiement = paiement;
	}
	public Collection<Enfant> getListEnfant() {
		return ListEnfant;
	}
	public void setListEnfant(Collection<Enfant> listEnfant) {
		ListEnfant = listEnfant;
	}
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCodeCommande() {
		return codeCommande;
	}
	public void setCodeCommande(long codeCommande) {
		this.codeCommande = codeCommande;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	
	
}
