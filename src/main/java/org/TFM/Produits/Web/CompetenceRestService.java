package org.TFM.Produits.Web;

import java.util.ArrayList;

import org.TFM.Produits.Entities.Competence;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.TypeProduit;
import org.TFM.Produits.DAO.CompetenceRepository;
import org.TFM.Produits.DAO.TypeProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CompetenceRestService{
	@Autowired 
	CompetenceRepository CompetenceRepository;
	@RequestMapping(value="/competences",method=RequestMethod.GET)
	public ArrayList<Competence> listAllCompetence()
	{
		return (ArrayList<Competence>) CompetenceRepository.findAll(); 
	}

	@RequestMapping(value="/PageCompetences",method=RequestMethod.GET)
	public Page<Competence> listPageCompetence(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		
		return CompetenceRepository.findPageCompetence(new PageRequest(page,size)); 
	}
	
	
	/* Ajouter Competence */
	@RequestMapping(value="/saveCompetence",method=RequestMethod.POST)
	public Competence saveCompetence(@RequestBody Competence f)
	{
		return CompetenceRepository.save(f); 
	}
	
	/* Supprimer Competence */
	@RequestMapping(value="/Competences/{codeCompetence}",method=RequestMethod.DELETE)
	public void deleteCompetence(@PathVariable ("codeCompetence") Long codeCompetence)
	{
		CompetenceRepository.delete(codeCompetence); 
	}
}
