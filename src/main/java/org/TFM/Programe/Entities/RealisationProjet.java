package org.TFM.Programe.Entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class RealisationProjet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeRealisation;
	
	@OneToMany
	@JoinTable(
			name = "ProjetSeance", 
			joinColumns = @JoinColumn(name = "CodeRealisation"),
			inverseJoinColumns = @JoinColumn(name = "codeSeance"))
	private Collection<Seance> ListSeance;
}
