package org.TFM.Commande.DAO;

import java.util.ArrayList;

import org.TFM.Commande.Entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

	@Query("select c from Commande c")
	public Page<Commande> findPageCommande(Pageable pageable);

	@Query("select c from Commande c ")
	public ArrayList<Commande> findCommande();
	
	
	@Query("select distinct c from Commande c , Client cl  " + 
			//   "where  cl.codeClient  = :x ")
"where c in elements(cl.ListEnfant.ListCommande) And cl.codeClient  = :x ")
	public ArrayList<Commande> getClientsCommands(@Param("x") Long idClient);

	
	
	
	
}
