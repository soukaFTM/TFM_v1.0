package org.TFM.Programe.Entities;

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
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.TFM.Clients.Entities.Enfant;
import org.TFM.Formateur.Entities.Formateur;

@Entity
public class Seance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeSeance;
	
	private Date dateDebut;
	
	private Date heureFin;
	
	private String Remarque;
	
	private int tauxRealisaton;
	
	@ManyToOne
	@JoinColumn(name = "CodeFormateur")
	public Formateur dirigeant;

	/*
	@ElementCollection(fetch = FetchType.LAZY)
    @JoinColumns({@JoinColumn(name = "codeSeance", referencedColumnName = "codeSeance"), 
    	@JoinColumn(name = "codeEnfant", referencedColumnName = "codeEnfant")})
    @OneToMany( fetch = FetchType.LAZY)
    @MapKey(name = "enfant")	
	private Map<Enfant,String> PresenceEnfants;*/
	
			
}
