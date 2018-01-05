package org.TFM.Produits.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author Xwomen
 * @version 1.0
 * @created 27-nov.-2017 11:34:07
 */
@Entity
@DiscriminatorValue("PROD") 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Produit extends AbstractProduit implements Serializable{

	@ManyToOne
	@JoinColumn(name = "CodeType")
	public TypeProduit typeProduit;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "ProduitCompetence", 
			joinColumns = @JoinColumn(name = "numProduit"),
			inverseJoinColumns = @JoinColumn(name = "codeCompetence"))
	private Collection<Competence> ListCompetence;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "ProduitProjet", 
			joinColumns = @JoinColumn(name = "numProduit"),
			inverseJoinColumns = @JoinColumn(name = "codeProjet"))
	private Collection<Projet> ListProjet;
	
	//@JsonIgnore
	public Collection<Competence> getListCompetence() {
		return ListCompetence;
	}
	//@JsonSetter
	public void setListCompetence(Collection<Competence> listCompetence) {
		ListCompetence = listCompetence;
	}
	//@JsonIgnore
	public Collection<Projet> getListProjet() {
		return ListProjet;
	}
	//@JsonSetter
	public void setListProjet(Collection<Projet> listProjet) {
		ListProjet = listProjet;
	}

	public TypeProduit getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}
	
	public Produit(String intituler, double prix, String description,TypeProduit typeProduit) {
		super(intituler,prix,description);
		this.typeProduit = typeProduit;
	}

	public Produit(){

	}

}

