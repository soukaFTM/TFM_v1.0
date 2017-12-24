package org.TFM.Programe.Entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.TFM.Clients.Entities.Enfant;

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
	
	
}
