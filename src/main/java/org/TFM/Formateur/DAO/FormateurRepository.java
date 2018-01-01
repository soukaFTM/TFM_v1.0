package org.TFM.Formateur.DAO;

import java.util.ArrayList;

import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Produits.Entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FormateurRepository extends JpaRepository<Formateur, Long>{

	/*Lister les formateurs */
	@Query("select f from Formateur f ")
	public Page<Formateur> findPageFormateur(Pageable pageable);
	@Query("select f from Formateur f ")
	public ArrayList<Formateur> findFormateur();
	
	// prk la requette => on a deja les listes dans l'objet formateur
	/*Lister les seances d'un formateur 
	@Query("select s from Formateur.mesSeances s ")
	public Page<Formateur> findPageFormateurSeances(Pageable pageable);
	@Query("select s from Formateur.mesSeances s ")
	public ArrayList<Formateur> findFormateurSeances();
	
	Lister les competences d'un formateur 
	@Query("select c from Formateur.mesCompetences c ")
	public Page<Formateur> findPageFormateurCompetences(Pageable pageable);
	@Query("select c from Formateur.mesCompetences c ")
	public ArrayList<Formateur> findFormateurCompetences();
	
	Lister les groupes d'un formateur 
	@Query("select g from Formateur.mesGroupes g ")
	public Page<Formateur> findPageFormateurGroupes(Pageable pageable);
	@Query("select g from Formateur.mesGroupes g ")
	public ArrayList<Formateur> findFormateurGroupes();
	*/
	/*Chercher formateur par CIN*/
	@Query("select f from Formateur f where f.CIN like :x ")
	public Page<Produit> chercherProduits(@Param("x") String mc,Pageable pageable);
	
	

}
