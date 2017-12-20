package org.TFM.Produits.Entities;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("PACK")
public class Pack extends AbstractProduit {
	@OneToMany
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
