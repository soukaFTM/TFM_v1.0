package org.TFM.Programe.Entities;

import java.sql.Time;
import java.sql.Time;
import java.util.Collection;

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

	private Time heureDebut = new Time(0);
	private Time heureFin =  new Time(0);
	private String jour;
	
	@ManyToOne
	@JoinColumn(name = "CodeFormateur")
	public Formateur responsable;
	
	public long getCodeGroupe() {
		return CodeGroupe;
	}

	public Time getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Time heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Time getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Time heureFin) {
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
