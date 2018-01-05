package org.TFM.Produits.DAO;

import org.TFM.Produits.Entities.Competence;
import org.TFM.Produits.Entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
	@Query("select p from Competence p ")
	public Page<Competence> findPageCompetence(Pageable pageable);
}
