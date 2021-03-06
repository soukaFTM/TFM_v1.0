package org.TFM.Programe.Web;

import java.util.ArrayList;

import org.TFM.Clients.Entities.Enfant;
import org.TFM.Commande.DAO.CommandeRepository;
import org.TFM.Commande.Entities.Commande;
import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Produits.DAO.ProjetRepository;
import org.TFM.Produits.Entities.AbstractProduit;
import org.TFM.Produits.Entities.Pack;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.Projet;
import org.TFM.Programe.DAO.GroupeRepository;
import org.TFM.Programe.DAO.ProgrammeRepository;
import org.TFM.Programe.DAO.RealisationProjetRepository;
import org.TFM.Programe.Entities.Groupe;
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

public class GroupeRestService {
	@Autowired 
	GroupeRepository groupeRepository;
	@Autowired 
	ProgrammeRepository programmeRepository;
	@Autowired 
	RealisationProjetRepository realisationProjetRepository;
	@Autowired
	ProjetRepository ProjetRepository;
	
	@RequestMapping(value="/Groupe/{codeGroupe}",method=RequestMethod.GET)
	public Groupe GetGroupe(@PathVariable ("codeGroupe") Long codeGroupe)
	{
		return (Groupe) groupeRepository.findOne(codeGroupe); 
	}
	@RequestMapping(value="/findGroupeOfProjet/{codeProjet}",method=RequestMethod.GET)
	public Groupe findGroupeOfProjet(@PathVariable ("codeProjet") Long codeProjet)
	{
		return (Groupe) groupeRepository.findGroupeOfProjet(codeProjet); 
	}
	
	
	
	@RequestMapping(value="/ProjetsDuGroupe/{codeGroupe}",method=RequestMethod.GET)
	public ArrayList<Projet> ProjetsDuGroupe(@PathVariable ("codeGroupe") Long codeGroupe)
	{
		
		ArrayList<Projet> listeProjet = new ArrayList<Projet>();
		listeProjet.addAll(ProjetRepository.findProjetsDuGroupeProduit(codeGroupe));
		listeProjet.addAll(ProjetRepository.findProjetsDuGroupePack(codeGroupe));
		
		/*for (Programme prog : programmeRepository.findAll()) {
			if(prog.getListGroupe().contains(groupeRepository.findOne(codeGroupe)))
			{
				AbstractProduit Aprod = prog.getProduit();
				System.out.println(Aprod.getIntituler()+ "+"+Aprod.getClass().getName());
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
		}*/
		return listeProjet;
	}
	
	
	
	@RequestMapping(value="/saveGroupe",method=RequestMethod.POST)
	public Groupe saveGroupe(@RequestBody Groupe g)
	{
		return groupeRepository.save(g); 
		
	}	

	
	
	/****************** Traitement commun *********************/
	
	@RequestMapping(value="/AllGroupe",method=RequestMethod.GET)
	public ArrayList<Groupe> listAllGroupe()
	{
		return (ArrayList<Groupe>) groupeRepository.findAll(); 
	}
	@RequestMapping(value="/Groupe/{numGroupe}",method=RequestMethod.DELETE)
	public void deleteGroupe(@PathVariable ("numGroupe") Long numGroupe)
	{
	   groupeRepository.delete(numGroupe); 
	}
	
	
	
	@RequestMapping(value="/addEnfantsToGroupe/{numGroupe}",method=RequestMethod.PUT)
	public Groupe addEnfantsToGroupe(@RequestBody ArrayList<Enfant> listEnfant,@PathVariable ("numGroupe") Long numGroupe)
	{
		Groupe groupe = (Groupe) groupeRepository.findOne(numGroupe);
		groupe.getListEnfant().addAll(listEnfant);
		return groupeRepository.save(groupe); 
	}

	@RequestMapping(value="/addRealisationProjetToGroupe/{numGroupe}",method=RequestMethod.PUT)
	public Groupe addRealisationProjetToGroupe(@RequestBody Projet projet,@PathVariable ("numGroupe") Long numGroupe)
	{
		Groupe groupe = (Groupe) groupeRepository.findOne(numGroupe);
		RealisationProjet realisation= new RealisationProjet();
		realisation.setProjet(projet);
		realisation = realisationProjetRepository.save(realisation);
		groupe.getListProjet().add(realisation);
		return groupeRepository.save(groupe); 
	}
	
	@RequestMapping(value="/addEnfantToGroupe/{numGroupe}",method=RequestMethod.PUT)
	public Groupe addEnfantToGroupe(@RequestBody Enfant e,@PathVariable ("numGroupe") Long numGroupe)
	{
		Groupe groupe = (Groupe) groupeRepository.findOne(numGroupe);
		groupe.getListEnfant().add(e);
		return groupeRepository.save(groupe); 
	}
	
	/*@RequestMapping(value="/addCommandeToGroupe/{numGroupe}",method=RequestMethod.PUT)
	public Groupe addCommandeToGroupe(@RequestBody Commande c,@PathVariable ("numGroupe") Long numGroupe)
	{
		Commande commande = commandeRepository.save(c);
		Groupe Groupe = (Groupe) groupeRepository.findOne(numGroupe);
		Groupe.getListCommande().add(commande);
		return groupeRepository.save(Groupe); 
	}*/
}
