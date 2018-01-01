package org.TFM.Produits.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
/**
 * @author Xwomen
 * @version 1.0
 * @created 27-nov.-2017 11:38:26
 */
@Entity 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="CategorieProduit",
discriminatorType=DiscriminatorType.STRING,length=7)
public class AbstractProduit {

	public AbstractProduit(String intituler, double prix, String description) {
		super();
		Intituler = intituler;
		Prix = prix;
		this.description = description;
	}

	private String Intituler;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long NumProduit;
	private double Prix;
	private String description;
	private Date DateCreation;
	private Date DateModification;
	private Date DateSuppression;
	

	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIntituler() {
		return Intituler;
	}

	public void setIntituler(String intituler) {
		Intituler = intituler;
	}

	public long getNumProduit() {
		return NumProduit;
	}

	public void setNumProduit(long numProduit) {
		NumProduit = numProduit;
	}

	public double getPrix() {
		return Prix;
	}

	public void setPrix(double prix) {
		Prix = prix;
	}

	public AbstractProduit(){

	}

	public String ToString(){
		return "";
	}

}