package org.TFM.Produits.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Xwomen
 * @version 1.0
 * @created 27-nov.-2017 11:34:07
 */
@Entity
@DiscriminatorValue("PROD") 
public class Produit extends AbstractProduit {

	@ManyToOne
	@JoinColumn(name = "CodeType")
	public TypeProduit typeProduit;

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

