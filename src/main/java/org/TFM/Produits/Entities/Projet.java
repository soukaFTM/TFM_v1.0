package org.TFM.Produits.Entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeProjet;
	private String Description;
	private String Intituler;
	private Date DateCreation;
	private Date DateModification;
	private Date DateSuppression;
	
	@ManyToMany
	private Collection<Produit> ListProduit;
	
	/*
	public Collection<Produit> getListProduit() {
		return ListProduit;
	}


	public void setListProduit(Collection<Produit> listProduit) {
		ListProduit = listProduit;
	}

*/
	public void setCodeProjet(long codeProjet) {
		CodeProjet = codeProjet;
	}


	public Projet(){

	}


	public long getCodeProjet() {
		return CodeProjet;
	}

	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getIntituler() {
		return Intituler;
	}


	public void setIntituler(String intituler) {
		Intituler = intituler;
	}


	public Date getDateCreation() {
		return DateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}


	public Date getDateModification() {
		return DateModification;
	}


	public void setDateModification(Date dateModification) {
		DateModification = dateModification;
	}


	public Date getDateSuppression() {
		return DateSuppression;
	}


	public void setDateSuppression(Date dateSuppression) {
		DateSuppression = dateSuppression;
	}


	public String ToString(){
		return "";
	}

}