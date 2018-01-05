package org.TFM.Programe.Web;

import java.util.ArrayList;

import org.TFM.Clients.Entities.Enfant;
import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Produits.Entities.AbstractProduit;
import org.TFM.Produits.Entities.Pack;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.Projet;
import org.TFM.Programe.DAO.RealisationProjetRepository;
import org.TFM.Programe.DAO.SeanceRepository;
import org.TFM.Programe.DAO.PresenceRepository;
import org.TFM.Programe.DAO.ProgrammeRepository;
import org.TFM.Programe.Entities.RealisationProjet;
import org.TFM.Programe.Entities.Seance;
import org.TFM.Programe.Entities.Groupe;
import org.TFM.Programe.Entities.Presence;
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
	@Autowired 
	SeanceRepository seanceRepository;
	@Autowired
	PresenceRepository presenceRepository;
	
	@RequestMapping(value="/RealisationProjet/{codeRealisationProjet}",method=RequestMethod.GET)

	public RealisationProjet GetRealisationProjet(@PathVariable ("codeRealisationProjet") Long codeRealisationProjet)
	{
		return (RealisationProjet) RealisationProjetRepository.findOne(codeRealisationProjet); 
	}
	
	
	@RequestMapping(value="/saveRealisationProjet",method=RequestMethod.POST)
	public RealisationProjet saveRealisationProjet(@RequestBody RealisationProjet g)
	{
		return RealisationProjetRepository.save(g); 
		
	}	
	
 
	@RequestMapping(value="/addSeanceToRealisationProjet/{numProjet}",method=RequestMethod.PUT)
	public RealisationProjet addSeanceToRealisationProjet(@PathVariable ("numProjet") Long numProjet,@RequestBody Seance s)
	{
		for (Presence p : s.getPresenceEnfants()) {
			presenceRepository.save(p);
		}
		Seance Seance = seanceRepository.save(s);
		
		RealisationProjet projet = (RealisationProjet) RealisationProjetRepository.findOne(numProjet);

		if(s.getCodeSeance()==null)
		{
			projet.getListSeance().add(Seance);
			RealisationProjetRepository.save(projet);
		}

		return projet; 
	}
	
	
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
	/*@RequestMapping(value="/addSeanceToRealisationProjet/{numRealisationProjet}",method=RequestMethod.PUT)
	public RealisationProjet addSeanceToRealisationProjet(@RequestBody Seance c,@PathVariable ("numRealisationProjet") Long numRealisationProjet)
	{
		Seance Seance = SeanceRepository.save(c);
		RealisationProjet RealisationProjet = (RealisationProjet) RealisationProjetRepository.findOne(numRealisationProjet);
		RealisationProjet.getListSeance().add(Seance);
		return RealisationProjetRepository.save(RealisationProjet); 
	}*/
}
