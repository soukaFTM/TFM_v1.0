package org.TFM.Programe.DAO;

import java.util.ArrayList;

import org.TFM.Produits.Entities.Pack;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Programe.Entities.Groupe;
import org.TFM.Programe.Entities.Programme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

	@Query("select g from Groupe g , RealisationProjet p "
			+ "where p in elements(g.ListProjet) And p.CodeRealisation  = :x ")
	public Groupe findGroupeOfProjet(@Param("x") Long id_Realisation);
	
}
