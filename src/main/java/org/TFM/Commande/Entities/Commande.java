package org.TFM.Commande.Entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.TFM.Clients.Entities.Enfant;
import org.TFM.Programe.Entities.Programme;

@Entity 
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeCommande;
	private double totale;
	
	@ManyToMany(mappedBy = "ListCommande")
	private Collection<Enfant> ListEnfant;

	@ManyToOne
	@JoinColumn(name = "CodeProgramme")
	public Programme programme;
	
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
