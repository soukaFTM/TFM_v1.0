package org.TFM.Formateur.Web;

import java.util.ArrayList;

import org.TFM.Formateur.DAO.FormateurRepository;
import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Produits.DAO.CompetenceRepository;
import org.TFM.Produits.DAO.ProduitRepository;
import org.TFM.Produits.Entities.AbstractProduit;
import org.TFM.Produits.Entities.Competence;
import org.TFM.Produits.Entities.Pack;
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
	@Autowired
	ProduitRepository produitRepository;
	
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
	
	/* Supprimer Formateur */
	@RequestMapping(value="/getFormateurByID/{codeFormateur}",method=RequestMethod.GET)
	public Formateur getFormateurByID(@PathVariable ("codeFormateur") Long codeFormateur)
	{
		return (Formateur)formateurRepository.findOne(codeFormateur); 
	}
	
	
	/* Modifier Formateur */
	
	
	@RequestMapping(value="/getAllResponsableForProgramme/{codeProduit}",method=RequestMethod.GET)
	public ArrayList<Formateur> getAllResponsableForProgramme(@PathVariable ("codeProduit") Long codeProduit)
	{
		ArrayList<Formateur> ResponsableForProgramme = new ArrayList<Formateur>();
		AbstractProduit Aprod = produitRepository.findOne(codeProduit);
		System.out.println(Aprod.getClass().getName());
		if(Aprod.getClass().getName().equals("org.TFM.Produits.Entities.Pack"))
		{
			Pack prod=(Pack)Aprod;
			boolean flag = true;
			 for (Formateur f : formateurRepository.findAll()) {
				 for (Produit p : prod.getListProduit()) {
					 if(!f.getMesCompetences().containsAll(p.getListCompetence()))
					 {		
						 flag = false;
					 	  break;
					 }
				}
			  if(flag) ResponsableForProgramme.add(f);
			}
		}
		else
		{
			Produit prod=(Produit)Aprod;
			 for (Formateur f : formateurRepository.findAll()) {
				 if(f.getMesCompetences().containsAll(prod.getListCompetence()))
					ResponsableForProgramme.add(f);
			}
		}
		return ResponsableForProgramme;
		
	}
	
	
	@RequestMapping(value="/addCompetenceToFormateur/{codeFormateur}",method=RequestMethod.PUT)
	public Formateur addCompetenceToFormateur(@RequestBody Competence comp,@PathVariable ("codeFormateur") Long codeFormateur)
	{
		Formateur Formateur = (Formateur) formateurRepository.findOne(codeFormateur);
		Formateur.getMesCompetences().add(comp);
		return formateurRepository.save(Formateur); 
		
	}
	@RequestMapping(value="/removeCompetenceFromFormateur/{codeFormateur}",method=RequestMethod.PUT)
	public Formateur removeCompetenceFromFormateur(@RequestBody Competence comp,@PathVariable ("codeFormateur") Long codeFormateur)
	{
		Formateur Formateur = (Formateur) formateurRepository.findOne(codeFormateur);
		for (Competence c : Formateur.getMesCompetences()) {
			if(c.getCodeCompetence()==comp.getCodeCompetence())
			{
				Formateur.getMesCompetences().remove(c);
				return formateurRepository.save(Formateur); 
			}
		}
		return formateurRepository.save(Formateur); 
	}
	
}
