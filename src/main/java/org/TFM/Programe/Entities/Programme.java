package org.TFM.Programe.Entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.TFM.Produits.Entities.Produit;

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
	
	
	


	
}
