package org.TFM.Produits.DAO;

import java.util.ArrayList;

import org.TFM.Produits.Entities.AbstractProduit;
import org.TFM.Produits.Entities.Competence;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.Projet;
import org.TFM.Produits.Entities.TypeProduit;
import org.TFM.Programe.Entities.Groupe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
	@Query("select p from Projet p ")
	public Page<Projet> findPageProjet(Pageable pageable);
	
	
	@Query("select projet from Produit produit ,  Groupe groupe , Programme programme , Projet projet "
			+ " where projet in elements(produit.ListProjet) and programme.produit = produit And groupe in elements(programme.ListGroupe) and groupe.CodeGroupe =:x")
	public ArrayList<Projet> findProjetsDuGroupeProduit(@Param("x") Long codeGroupe);
	
	
	@Query("select projet from Produit produit ,  Groupe groupe , Programme programme , Projet projet , Pack pack "
			+ "where projet in elements(produit.ListProjet)  And produit in elements(pack.ListProduit) and programme.produit = pack And groupe in elements(programme.ListGroupe) And groupe.CodeGroupe =:x")
	public ArrayList<Projet> findProjetsDuGroupePack(@Param("x") Long codeGroupe);
	

	
}
