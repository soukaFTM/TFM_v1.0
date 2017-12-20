package org.TFM.Produits.DAO;


import org.TFM.Produits.Entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource 
public interface PromotionRepository extends JpaRepository<Promotion, Long>{
	
}
