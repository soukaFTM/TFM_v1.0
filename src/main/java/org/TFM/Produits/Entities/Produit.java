package org.TFM.Produits.Entities;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

	@OneToMany
	@JoinTable(
			name = "ProduitCompetence", 
			joinColumns = @JoinColumn(name = "NumProduit"),
			inverseJoinColumns = @JoinColumn(name = "codeCompetence"))
	private Collection<Competence> ListCompetence;
	
	@OneToMany
	@JoinTable(
			name = "ProduitProjet", 
			joinColumns = @JoinColumn(name = "NumProduit"),
			inverseJoinColumns = @JoinColumn(name = "codeProjet"))
	private Collection<Projet> ListProjet;
	
	public Collection<Competence> getListCompetence() {
		return ListCompetence;
	}

	public void setListCompetence(Collection<Competence> listCompetence) {
		ListCompetence = listCompetence;
	}

	public Collection<Projet> getListProjet() {
		return ListProjet;
	}

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

