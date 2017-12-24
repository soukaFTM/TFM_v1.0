package org.TFM.Produits.Web;

import java.util.ArrayList;

import org.TFM.Produits.Entities.Competence;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.TypeProduit;
import org.TFM.Produits.DAO.CompetenceRepository;
import org.TFM.Produits.DAO.TypeProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CompetenceRestService{
	@Autowired 
	CompetenceRepository competenceRepository;
	@RequestMapping(value="/competences",method=RequestMethod.GET)
	public ArrayList<Competence> listAllCompetence()
	{
		return (ArrayList<Competence>) competenceRepository.findAll(); 
	}

}
