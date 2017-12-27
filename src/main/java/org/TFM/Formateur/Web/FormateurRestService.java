package org.TFM.Formateur.Web;

import java.util.ArrayList;

import org.TFM.Formateur.DAO.FormateurRepository;
import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Produits.DAO.CompetenceRepository;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Programe.DAO.GroupeRepository;
import org.TFM.Programe.DAO.SeanceRepository;
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
public class FormateurRestService {

	@Autowired
	FormateurRepository formateurRepository;
	@Autowired
	CompetenceRepository competenceRepository;
	@Autowired
	SeanceRepository seanceRepository;
	@Autowired
	GroupeRepository groupeRepository;
	
	/* Lister les formateurs par page */
	@RequestMapping(value="/PageFormateurs",method=RequestMethod.GET)
	public Page<Formateur> listPageFormateur(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		
		return formateurRepository.findPageFormateur(new PageRequest(page,size)); 
	}
	
	/* Lister tous les formateurs */
	@RequestMapping(value="/AllFomateurs",method=RequestMethod.GET)
	public ArrayList<Formateur> listAllFormateur()
	{
		return (ArrayList<Formateur>) formateurRepository.findFormateur(); 
	}
	
	/* Ajouter Formateur */
	@RequestMapping(value="/saveFormateur",method=RequestMethod.POST)
	public Formateur saveFormateur(@RequestBody Formateur f)
	{
		return formateurRepository.save(f); 
	}
	
	/* Supprimer Formateur */
	@RequestMapping(value="/formateurs/{codeFormateur}",method=RequestMethod.DELETE)
	public void deleteFormateur(@PathVariable ("codeFormateur") Long codeFormateur)
	{
		formateurRepository.delete(codeFormateur); 
	}
	
	/* Modifier Formateur */
	
}
