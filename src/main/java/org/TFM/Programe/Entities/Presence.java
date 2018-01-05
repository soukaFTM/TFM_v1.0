package org.TFM.Programe.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

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

public class Presence implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodePresence;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codeEnfant")
	public Enfant enfant;

	private Boolean presence;

	private String remarque;

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public long getCodePresence() {
		return CodePresence;
	}

	public void setCodePresence(long codePresence) {
		CodePresence = codePresence;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public Boolean getPresence() {
		return presence;
	}

	public void setPresence(Boolean presence) {
		this.presence = presence;
	}

	public Presence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
			
}
