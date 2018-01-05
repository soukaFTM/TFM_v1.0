package org.TFM.Produits.Entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("PACK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Pack extends AbstractProduit implements Serializable{
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "PackProduit", 
			joinColumns = @JoinColumn(name = "NumPack"),
			inverseJoinColumns = @JoinColumn(name = "NumProduit"))
	private Collection<Produit> ListProduit;

	public Pack() {
		super();
		ListProduit = new ArrayList<Produit>();
	}

	@Override
	public String toString() {
		return "ProdPack [ListProduit=" + ListProduit + ", getNumProduit()=" + getNumProduit() + ", getIntituler()="
				+ getIntituler() + ", getDescription()=" + getDescription() + ", getPrix()=" + getPrix() + "]";
	}

	public Collection<Produit> getListProduit() {
		return ListProduit;
	}
	
}
