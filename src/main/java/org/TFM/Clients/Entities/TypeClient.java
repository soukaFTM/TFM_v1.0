package org.TFM.Clients.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.TFM.Produits.Entities.TypeProduit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Xwomen
 * @version 1.0
 * @created 27-nov.-2017 11:34:09
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class TypeClient implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeType;
	private String Description;
	private String Intituler;
	private Date DateCreation;
	private Date DateModification;
	private Date DateSuppression;
	

	public TypeClient(){

	}


	public long getCodeType() {
		return CodeType;
	}


	public void setCodeType(long codeType) {
		CodeType = codeType;
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