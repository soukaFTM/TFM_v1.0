package org.TFM.Formateur.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class SuiviMensuelle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeSuivi;
	
	private Date finMois;
	private int nbrHeure=0;
	private int nbrSeance=0;
	private int salaire=0;
	private Boolean paiement = false;
	
	
	
	public Boolean getPaiement() {
		return paiement;
	}
	public void setPaiement(Boolean paiement) {
		this.paiement = paiement;
	}
	public SuiviMensuelle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCodeSuivi() {
		return CodeSuivi;
	}
	public void setCodeSuivi(long codeSuivi) {
		CodeSuivi = codeSuivi;
	}
	public Date getFinMois() {
		return finMois;
	}
	public void setFinMois(Date finMois) {
		this.finMois = finMois;
	}
	public int getNbrHeure() {
		return nbrHeure;
	}
	public void setNbrHeure(int nbrHeure) {
		this.nbrHeure = nbrHeure;
	}
	public int getNbrSeance() {
		return nbrSeance;
	}
	public void setNbrSeance(int nbrSeance) {
		this.nbrSeance = nbrSeance;
		this.nbrHeure= this.nbrSeance*2;
		this.salaire=this.nbrHeure*70;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		salaire = salaire;
	}
	
	
	
}
