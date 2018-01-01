package org.TFM.Programe.Entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.TFM.Produits.Entities.Projet;
import org.TFM.Produits.Entities.TypeProduit;

@Entity
public class RealisationProjet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CodeRealisation;
	private int evaluationGlobal;
	private String remarque;
	
	@ManyToOne
	@JoinColumn(name = "codeProjet")
	private Projet projet;
	
	@OneToMany
	@JoinTable(
			name = "ProjetSeance", 
			joinColumns = @JoinColumn(name = "CodeRealisation"),
			inverseJoinColumns = @JoinColumn(name = "codeSeance"))
	private Collection<Seance> ListSeance;

	public long getCodeRealisation() {
		return CodeRealisation;
	}

	public void setCodeRealisation(long codeRealisation) {
		CodeRealisation = codeRealisation;
	}

	public int getEvaluationGlobal() {
		return evaluationGlobal;
	}

	public void setEvaluationGlobal(int evaluationGlobal) {
		this.evaluationGlobal = evaluationGlobal;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Collection<Seance> getListSeance() {
		return ListSeance;
	}

	public void setListSeance(Collection<Seance> listSeance) {
		ListSeance = listSeance;
	}

	public RealisationProjet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
