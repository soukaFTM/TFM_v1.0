package org.TFM.Programe.Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Programme implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeProgramme;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "ProgrammeGroupe", 
			joinColumns = @JoinColumn(name = "codeProgramme"),
			inverseJoinColumns = @JoinColumn(name = "codeGroupe"))
	private Collection<Groupe> ListGroupe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CodeProduit")
	private AbstractProduit produit;
	
	private int dureeSeance;
	
	
	public int getDureeSeance() {
		return dureeSeance;
	}

	public void setDureeSeance(int dureeSeance) {
		this.dureeSeance = dureeSeance;
	}

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
