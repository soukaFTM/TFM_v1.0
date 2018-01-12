package org.TFM.Produits.DAO;


import java.util.ArrayList;

import org.TFM.Commande.Entities.Commande;
import org.TFM.Produits.Entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource 
public interface PromotionRepository extends JpaRepository<Promotion, Long>{

	
	@Query("select  p from Promotion p , Produit pr " + 
			"where pr in elements(p.listeProduit) And pr.NumProduit  = :x ")
	public ArrayList<Promotion> getPromotionOfProduit(@Param("x") Long idProduit);

	
}
