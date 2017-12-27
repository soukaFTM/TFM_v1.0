package org.TFM.Programe.Entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.TFM.Clients.Entities.Enfant;
import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Produits.Entities.AbstractProduit;

@Entity
public class Groupe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeGroupe;
	
	@OneToMany
	@JoinTable(
			name = "GroupeEnfant", 
			joinColumns = @JoinColumn(name = "codeGroupe"),
			inverseJoinColumns = @JoinColumn(name = "codeEnfant"))
	private Collection<Enfant> ListEnfant;
	
	@OneToMany
	@JoinTable(
			name = "GroupeProjet", 
			joinColumns = @JoinColumn(name = "codeGroupe"),
			inverseJoinColumns = @JoinColumn(name = "codeRealisation"))
	private Collection<RealisationProjet> ListProjet;

	private Date heureDebut;
	private Date heureFin;
	private String jour;
	
	@ManyToOne
	@JoinColumn(name = "CodeFormateur")
	public Formateur responsable;
	
	public long getCodeGroupe() {
		return CodeGroupe;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public Formateur getResponsable() {
		return responsable;
	}

	public void setResponsable(Formateur responsable) {
		this.responsable = responsable;
	}

	public void setCodeGroupe(long codeGroupe) {
		CodeGroupe = codeGroupe;
	}

	public Collection<Enfant> getListEnfant() {
		return ListEnfant;
	}

	public void setListEnfant(Collection<Enfant> listEnfant) {
		ListEnfant = listEnfant;
	}

	public Collection<RealisationProjet> getListProjet() {
		return ListProjet;
	}

	public void setListProjet(Collection<RealisationProjet> listProjet) {
		ListProjet = listProjet;
	}
	
	
}
