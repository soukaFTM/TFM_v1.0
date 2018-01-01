package org.TFM.Clients.DAO;

import java.util.ArrayList;

import org.TFM.Clients.Entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long>{

	/*tous types de clients */
	@Query("select c from Client c ")
	public Page<Client> findPageClient(Pageable pageable);
	@Query("select c from Client c ")
	public ArrayList<Client> findClient();

	/*les clients Physique*/
	@Query("select c from ClientPhysique c ")
	public Page<Client> findPageClientPhysique(Pageable pageable);
	@Query("select c from ClientPhysique c ")
	public ArrayList<Client> findClientPhysique();

	/*les clients Moraux*/
	@Query("select c from ClientMoral c ")
	public Page<Client> findPageClientMoral(Pageable pageable);
	@Query("select c from ClientMoral c ")
	public ArrayList<Client> findClientMoral();
	/*
	/*les clients Potentiels*/ 
	// Declanche des erreurs
/*	@Query("select c from Client c where c.ListEnfant")
	public Page<Client> findPageClientPotentiel(Pageable pageable);
	@Query("select c from ClientMoral c ")
	public ArrayList<Client> findClientPotentiel();

*/


	
	

	
}
