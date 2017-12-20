package org.TFM.Produits.Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Promotion implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codePromo;
	private String intituler;
	private String description;
	private double taux;
	@OneToMany
	@JoinTable(
			name = "ProduitPromotion", 
			joinColumns = @JoinColumn(name = "CodePromo"),
			inverseJoinColumns = @JoinColumn(name = "NumProduit"))
	private Collection<AbstractProduit> listeProduit;
	private Date dateDebut;
	private Date dateFin;
	private Date dateCreation;
	private Date dateModification;
	private Date dateSuppression;
	public Long getCodePromo() {
		return codePromo;
	}
	public void setCodePromo(Long codePromo) {
		this.codePromo = codePromo;
	}
	public String getIntituler() {
		return intituler;
	}
	public void setIntituler(String intituler) {
		this.intituler = intituler;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public Collection<AbstractProduit> getListeProduit() {
		return listeProduit;
	}
	public void setListeProduit(Collection<AbstractProduit> listeProduit) {
		listeProduit = listeProduit;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public Date getDateSuppression() {
		return dateSuppression;
	}
	public void setDateSuppression(Date dateSuppression) {
		this.dateSuppression = dateSuppression;
	}
	public Promotion(Long codePromo, String intituler, String description, double taux,
			Collection<AbstractProduit> listeProduit, Date dateDebut, Date dateFin, Date dateCreation,
			Date dateModification, Date dateSuppression) {
		super();
		this.codePromo = codePromo;
		this.intituler = intituler;
		this.description = description;
		this.taux = taux;
		this.listeProduit = listeProduit;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.dateSuppression = dateSuppression;
	}
	public Promotion() {
	}
	
	
	
}
