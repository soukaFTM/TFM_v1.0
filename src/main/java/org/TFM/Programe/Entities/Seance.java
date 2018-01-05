package org.TFM.Programe.Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.TFM.Clients.Entities.Enfant;
import org.TFM.Formateur.Entities.Formateur;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Seance implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long CodeSeance;
	
	private Date dateDebut;
	
	private Date heureFin;
	
	private String Remarque;
	
	private int tauxRealisaton;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CodeFormateur")
	public Formateur dirigeant;


    @OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "SeancePresence", 
			joinColumns = @JoinColumn(name = "codeSeance"),
			inverseJoinColumns = @JoinColumn(name = "codePresence"))
	private Collection<Presence> PresenceEnfants = new ArrayList<Presence>();


	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getCodeSeance() {
		return CodeSeance;
	}


	public void setCodeSeance(Long codeSeance) {
		CodeSeance = codeSeance;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getHeureFin() {
		return heureFin;
	}


	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}


	public String getRemarque() {
		return Remarque;
	}


	public void setRemarque(String remarque) {
		Remarque = remarque;
	}


	public int getTauxRealisaton() {
		return tauxRealisaton;
	}


	public void setTauxRealisaton(int tauxRealisaton) {
		this.tauxRealisaton = tauxRealisaton;
	}


	public Formateur getDirigeant() {
		return dirigeant;
	}


	public void setDirigeant(Formateur dirigeant) {
		this.dirigeant = dirigeant;
	}


	public Collection<Presence> getPresenceEnfants() {
		return PresenceEnfants;
	}


	public void setPresenceEnfants(Collection<Presence> presenceEnfants) {
		PresenceEnfants = presenceEnfants;
	}
	
    
    
			
}
