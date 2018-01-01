package org.TFM.Programe.Entities;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.TFM.Produits.Entities.AbstractProduit;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.TypeProduit;

@Entity
public class Programme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeProgramme;
	
	@OneToMany
	@JoinTable(
			name = "ProgrammeGroupe", 
			joinColumns = @JoinColumn(name = "codeProgramme"),
			inverseJoinColumns = @JoinColumn(name = "codeGroupe"))
	private Collection<Groupe> ListGroupe;

	@ManyToOne
	@JoinColumn(name = "CodeProduit")
	public AbstractProduit produit;
	
	public AbstractProduit getProduit() {
		return produit;
	}

	public void setProduit(AbstractProduit produit) {
		this.produit = produit;
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

	private Date dateDebut;
	private Date dateFin;
	
	public long getCodeProgramme() {
		return CodeProgramme;
	}

	public void setCodeProgramme(long codeProgramme) {
		CodeProgramme = codeProgramme;
	}

	public Collection<Groupe> getListGroupe() {
		return ListGroupe;
	}

	public void setListGroupe(Collection<Groupe> listGroupe) {
		ListGroupe = listGroupe;
	}
	
	
	


	
}
