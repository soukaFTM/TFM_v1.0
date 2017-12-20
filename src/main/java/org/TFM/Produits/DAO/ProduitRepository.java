package org.TFM.Produits.DAO;

import java.util.ArrayList;

import org.TFM.Produits.Entities.Pack;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.AbstractProduit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<AbstractProduit, Long>{

	@Query("select p from Produit p where p.Intituler like :x ")
	public Page<Produit> chercherProduits(@Param("x") String mc,Pageable pageable);

	@Query("select p from Pack p where p.Intituler like :x ")
	public Page<Pack> chercherPack(@Param("x") String mc,Pageable pageable);

	@Query("select p from Produit p ")
	public Page<Produit> findPageProd(Pageable pageable);

	@Query("select p from Pack p ")
	public Page<Pack> findPagePack(Pageable pageable);

	@Query("select p from Produit p ")
	public ArrayList<Produit> findProduits();

	@Query("select p from Pack p ")
	public ArrayList<Pack> findPacks();
	

	

	
}
