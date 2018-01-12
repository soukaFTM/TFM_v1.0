package org.TFM.Formateur.DAO;

import java.util.ArrayList;

import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Formateur.Entities.SuiviMensuelle;
import org.TFM.Produits.Entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SuiviMensuelleRepository extends JpaRepository<SuiviMensuelle, Long>{


	/*@Query("select f from SuiviMensuelle f ")
	public ArrayList<SuiviMensuelle> SuiviMensuelleOfFormateur();
	
	
	/*Chercher formateur par CIN*/
	/*@Query("select f from Formateur f where f.CIN like :x ")
	public Page<Produit> chercherProduits(@Param("x") String mc,Pageable pageable);
	*/
	

}
