package org.TFM.Produits.Web;

import java.util.ArrayList;

import org.TFM.Produits.Entities.Competence;
import org.TFM.Produits.Entities.Projet;
import org.TFM.Produits.Entities.Projet;
import org.TFM.Clients.Entities.Client;
import org.TFM.Clients.Entities.Enfant;
import org.TFM.Produits.DAO.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ProjetRestService{
	@Autowired 
	ProjetRepository ProjetRepository;
	@RequestMapping(value="/projets",method=RequestMethod.GET)
	public ArrayList<Projet> listAllProduit()
	{
		return (ArrayList<Projet>) ProjetRepository.findAll(); 
	}
	
	@RequestMapping(value="/Projets",method=RequestMethod.GET)
	public ArrayList<Projet> listAllProjet()
	{
		return (ArrayList<Projet>) ProjetRepository.findAll(); 
	}

	@RequestMapping(value="/PageProjets",method=RequestMethod.GET)
	public Page<Projet> listPageProjet(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		
		return ProjetRepository.findPageProjet(new PageRequest(page,size)); 
	}
	
	
	/* Ajouter Projet */
	@RequestMapping(value="/saveProjet",method=RequestMethod.POST)
	public Projet saveProjet(@RequestBody Projet f)
	{
		return ProjetRepository.save(f); 
	}
	
	/* Supprimer Projet */
	@RequestMapping(value="/Projets/{codeProjet}",method=RequestMethod.DELETE)
	public void deleteProjet(@PathVariable ("codeProjet") Long codeProjet)
	{
		ProjetRepository.delete(codeProjet); 
	}
	

}
