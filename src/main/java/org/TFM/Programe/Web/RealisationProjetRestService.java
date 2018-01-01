package org.TFM.Programe.Web;

import java.util.ArrayList;

import org.TFM.Clients.Entities.Enfant;
import org.TFM.Commande.DAO.CommandeRepository;
import org.TFM.Commande.Entities.Commande;
import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Produits.Entities.AbstractProduit;
import org.TFM.Produits.Entities.Pack;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.Projet;
import org.TFM.Programe.DAO.RealisationProjetRepository;
import org.TFM.Programe.DAO.ProgrammeRepository;
import org.TFM.Programe.Entities.RealisationProjet;
import org.TFM.Programe.Entities.Programme;
import org.TFM.Programe.Entities.RealisationProjet;
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

public class RealisationProjetRestService {
	@Autowired 
	RealisationProjetRepository RealisationProjetRepository;
	@Autowired 
	ProgrammeRepository programmeRepository;
	/*
	@RequestMapping(value="/RealisationProjet/{codeRealisationProjet}",method=RequestMethod.GET)
	public RealisationProjet GetRealisationProjet(@PathVariable ("codeRealisationProjet") Long codeRealisationProjet)
	{
		return (RealisationProjet) RealisationProjetRepository.findOne(codeRealisationProjet); 
	}
	
	@RequestMapping(value="/ProjetsDuRealisationProjet/{codeRealisationProjet}",method=RequestMethod.GET)
	public ArrayList<Projet> ProjetsDuRealisationProjet(@PathVariable ("codeRealisationProjet") Long codeRealisationProjet)
	{
		
		ArrayList<Projet> listeProjet = new ArrayList<Projet>();
		for (Programme prog : programmeRepository.findAll()) {
			if(prog.getListRealisationProjet().contains(RealisationProjetRepository.findOne(codeRealisationProjet)))
			{
				AbstractProduit Aprod = prog.getProduit();
				if(Aprod.getClass().getName().equals("org.TFM.Produits.Entities.Pack"))
				{
					Pack prod=(Pack)Aprod;
					 for (Produit p : prod.getListProduit()) 
						 listeProjet.addAll(p.getListProjet());
				}
				else
				{
					Produit prod=(Produit)Aprod;
					 listeProjet.addAll(prod.getListProjet());
					
				}
			}
		}
		return listeProjet;
	}
	
	
	
	@RequestMapping(value="/saveRealisationProjet",method=RequestMethod.POST)
	public RealisationProjet saveRealisationProjet(@RequestBody RealisationProjet g)
	{
		return RealisationProjetRepository.save(g); 
		
	}	
	
	/*
 @RequestMapping(value="/addCommandeToRealisationProjet/{codeCommande}",method=RequestMethod.PUT)
	public RealisationProjet addCommandeToRealisationProjet(@RequestBody RealisationProjetPotentiel RealisationProjet,@PathVariable ("numcmd") Long numcmd)
	{
		RealisationProjet RealisationProjetPotentiel = (RealisationProjet) RealisationProjetRepository.findOne(numRealisationProjet);
		RealisationProjetPotentiel.getListRealisationProjetPotentiel().add(RealisationProjet);
		return RealisationProjetRepository.save(RealisationProjetPotentiel); 
		
	}*/
/*@RequestMapping(value="/removeRealisationProjetPotentielFromRealisationProjet/{numRealisationProjet}",method=RequestMethod.PUT)
	public RealisationProjet removeRealisationProjetPotentielFromRealisationProjet(@RequestBody RealisationProjet RealisationProjetAsupp,@PathVariable ("numRealisationProjet") Long numRealisationProjet)
	{
		RealisationProjet RealisationProjetPotentiel = (RealisationProjet) RealisationProjetRepository.findOne(numRealisationProjet);
		for (AbstractRealisationProjetPotentiel p : RealisationProjetPotentiel.getListRealisationProjetPotentiel()) {
			if(p.getNumRealisationProjetPotentiel()==RealisationProjetAsupp.getNumRealisationProjetPotentiel())
			{
				RealisationProjetPotentiel.getListRealisationProjetPotentiel().remove(p);
				return RealisationProjetRepository.save(RealisationProjetPotentiel); 
			}
		}
		return RealisationProjetRepository.save(RealisationProjetPotentiel); 
	}*/
	
	
	/****************** Traitement commun *********************/
	/*
	@RequestMapping(value="/AllRealisationProjet",method=RequestMethod.GET)
	public ArrayList<RealisationProjet> listAllRealisationProjet()
	{
		return (ArrayList<RealisationProjet>) RealisationProjetRepository.findAll(); 
	}
	@RequestMapping(value="/RealisationProjet/{numRealisationProjet}",method=RequestMethod.DELETE)
	public void deleteRealisationProjet(@PathVariable ("numRealisationProjet") Long numRealisationProjet)
	{
	   RealisationProjetRepository.delete(numRealisationProjet); 
	}
	
	

	@RequestMapping(value="/addRealisationProjetToRealisationProjet/{numRealisationProjet}",method=RequestMethod.PUT)
	public RealisationProjet addRealisationProjetToRealisationProjet(@RequestBody Projet projet,@PathVariable ("numRealisationProjet") Long numRealisationProjet)
	{
		RealisationProjet RealisationProjet = (RealisationProjet) RealisationProjetRepository.findOne(numRealisationProjet);
		RealisationProjet realisation= new RealisationProjet();
		realisation.setProjet(projet);
		
		RealisationProjet.getListProjet().add(realisation);
		return RealisationProjetRepository.save(RealisationProjet); 
	}
	
	@RequestMapping(value="/addEnfantToRealisationProjet/{numRealisationProjet}",method=RequestMethod.PUT)
	public RealisationProjet addEnfantToRealisationProjet(@RequestBody Enfant e,@PathVariable ("numRealisationProjet") Long numRealisationProjet)
	{
		RealisationProjet RealisationProjet = (RealisationProjet) RealisationProjetRepository.findOne(numRealisationProjet);
		RealisationProjet.getListEnfant().add(e);
		return RealisationProjetRepository.save(RealisationProjet); 
	}
	*/
	/*@RequestMapping(value="/addCommandeToRealisationProjet/{numRealisationProjet}",method=RequestMethod.PUT)
	public RealisationProjet addCommandeToRealisationProjet(@RequestBody Commande c,@PathVariable ("numRealisationProjet") Long numRealisationProjet)
	{
		Commande commande = commandeRepository.save(c);
		RealisationProjet RealisationProjet = (RealisationProjet) RealisationProjetRepository.findOne(numRealisationProjet);
		RealisationProjet.getListCommande().add(commande);
		return RealisationProjetRepository.save(RealisationProjet); 
	}*/
}
