package org.TFM.Formateur.Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.TFM.Produits.Entities.Competence;
import org.TFM.Programe.Entities.Groupe;
import org.TFM.Programe.Entities.Seance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Formateur implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeFormateur;
	
	private String CIN;
	private Date datedebut;
	private String nom;
	private String prenom;
	private String typedecontrat;
	
	@OneToMany
	@JoinTable(
			name = "SeancesFormateur", 
			joinColumns = @JoinColumn(name = "CodeFormateur"),
			inverseJoinColumns = @JoinColumn(name = "CodeSeance"))
	private List<Seance> mesSeances;
	
	@OneToMany
	@JoinTable(
			name = "GroupesFormateur", 
			joinColumns = @JoinColumn(name = "CodeFormateur"),
			inverseJoinColumns = @JoinColumn(name = "CodeGroupe"))
	private List<Groupe> mesGroupes;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "CompetencesFormateur", 
			joinColumns = @JoinColumn(name = "CodeFormateur"),
			inverseJoinColumns = @JoinColumn(name = "CodeCompetence"))
	private List<Competence> mesCompetences;
	
	public List<Competence> getMesCompetences() {
		return mesCompetences;
	}

	public void setMesCompetences(List<Competence> mesCompetences) {
		this.mesCompetences = mesCompetences;
	}

	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formateur(String cIN, Date datedebut, String nom, String prenom, String typedecontrat) {
		super();
		CIN = cIN;
		this.datedebut = datedebut;
		this.nom = nom;
		this.prenom = prenom;
		this.typedecontrat = typedecontrat;
	}

	public long getCodeFormateur() {
		return CodeFormateur;
	}

	public void setCodeFormateur(long codeFormateur) {
		CodeFormateur = codeFormateur;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTypedecontrat() {
		return typedecontrat;
	}

	public void setTypedecontrat(String typedecontrat) {
		this.typedecontrat = typedecontrat;
	}

	public List<Seance> getMesSeances() {
		return mesSeances;
	}

	public void setMesSeances(List<Seance> mesSeances) {
		this.mesSeances = mesSeances;
	}

	public List<Groupe> getMesGroupes() {
		return mesGroupes;
	}

	public void setMesGroupes(List<Groupe> mesGroupes) {
		this.mesGroupes = mesGroupes;
	}
	
}
