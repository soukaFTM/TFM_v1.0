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
import org.TFM.Programe.DAO.GroupeRepository;
import org.TFM.Programe.DAO.RealisationProjetRepository;
import org.TFM.Programe.DAO.SeanceRepository;
import org.TFM.Programe.DAO.SeanceRepository;
import org.TFM.Programe.Entities.Seance;
import org.TFM.Programe.Entities.Groupe;
import org.TFM.Programe.Entities.RealisationProjet;
import org.TFM.Programe.Entities.Seance;
import org.TFM.Programe.Entities.Seance;
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

public class SeanceProjetRestService {
	@Autowired 
	SeanceRepository SeanceRepository;
	@Autowired 
	GroupeRepository groupeRepository;
	@Autowired
	RealisationProjetRepository RealisationRepository;
	
	

	@RequestMapping(value="/AllSeance",method=RequestMethod.GET)
	public ArrayList<Seance> listAllSeance()
	{
		return (ArrayList<Seance>) SeanceRepository.findAll(); 
	}
	
	@RequestMapping(value="/GetSeanceOfGroupe/{codeProject}",method=RequestMethod.GET)
	public ArrayList<Seance>  GetSeanceOfGroupeProject(@PathVariable ("codeProject") Long codeProject)
	{
		RealisationProjet projet =(RealisationProjet) RealisationRepository.findOne(codeProject); 
		return (ArrayList<Seance>) projet.getListSeance();
	}
	
	
	@RequestMapping(value="/saveSeance",method=RequestMethod.POST)
	public Seance saveSeance(@RequestBody Seance p,@PathVariable ("numProjet") Long numSeance)
	{
		return SeanceRepository.save(p); 
	}	
	
	@RequestMapping(value="/Seance/{numSeance}",method=RequestMethod.DELETE)
	public void deleteSeance(@PathVariable ("numSeance") Long numSeance)
	{
	   SeanceRepository.delete(numSeance); 
	}

	/*@RequestMapping(value="/addGroupeToSeance/{numSeance}",method=RequestMethod.PUT)
	public Seance addGroupeToSeance(@RequestBody Groupe e,@PathVariable ("numSeance") Long numSeance)
	{
		Groupe Groupe = groupeRepository.save(e);
		Seance Seance = (Seance) SeanceRepository.findOne(numSeance);
		Seance.getListGroupe().add(Groupe);
		return SeanceRepository.save(Seance); 
	}*/
}
