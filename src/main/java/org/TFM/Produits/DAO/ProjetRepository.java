package org.TFM.Produits.DAO;

import org.TFM.Produits.Entities.Projet;
import org.TFM.Produits.Entities.TypeProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
