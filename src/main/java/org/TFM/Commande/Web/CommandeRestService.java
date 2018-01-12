package org.TFM.Commande.Web;

import java.util.ArrayList;

import org.TFM.Clients.DAO.EnfantRepository;
import org.TFM.Clients.Entities.Client;
import org.TFM.Clients.Entities.Enfant;
import org.TFM.Commande.DAO.CommandeRepository;
import org.TFM.Commande.Entities.Commande;
import org.TFM.Programe.DAO.ProgrammeRepository;
import org.TFM.Programe.Entities.Presence;
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
public class CommandeRestService {
	@Autowired 
	CommandeRepository commandeRepository;
	@Autowired 
	EnfantRepository enfantRepository;
	@Autowired 
	ProgrammeRepository programmeRepository;
	
	@RequestMapping(value="/PageCommande",method=RequestMethod.GET)
	public Page<Commande> listPageCommande(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		return commandeRepository.findPageCommande(new PageRequest(page,size)); 
	}
	@RequestMapping(value="/AllCommandes",method=RequestMethod.GET)
	public ArrayList<Commande> listAllCommande()
	{
		return (ArrayList<Commande>) commandeRepository.findCommande(); 
	}
	
	@RequestMapping(value="/getClientsCommands/{idClient}",method=RequestMethod.GET)
	public ArrayList<Commande> getClientsCommands(@PathVariable ("idClient") Long idClient)
	{
		return (ArrayList<Commande>) commandeRepository.getClientsCommands(idClient); 
	}
	
	@RequestMapping(value="/saveCommande",method=RequestMethod.POST)
	public Commande saveCommande(@RequestBody Commande p)
	{
		
		p.setProgramme(programmeRepository.findOne(p.getProgramme().getCodeProgramme()));
		Commande cmd =(Commande) commandeRepository.save(p); 
		
		for (Enfant e : p.getListEnfant() )  {
			Enfant enf = enfantRepository.findOne(e.getCodeEnfant());
			
			if(enf.getListCommande()==null)
				enf.setListCommande(new ArrayList<Commande>());

			enf.getListCommande().add(cmd);
			
			enfantRepository.save(enf);
		}
		
		return cmd;
	}
	@RequestMapping(value="/PaimentCommande",method=RequestMethod.PUT)
	public Commande PaimentCommande(@RequestBody Commande p)
	{
		//System.out.println(p.getTotale());
		//Commande cmd = commandeRepository.findOne(p.getCodeCommande());
		p.setPaiement(true);
		return (Commande) commandeRepository.save(p); 
		
	}
	@RequestMapping(value="/Commande/{numCommande}",method=RequestMethod.DELETE)
	public void deletCommande(@PathVariable ("numCommande") Long numCommande)
	{
	   commandeRepository.delete(numCommande); 
	}
	/*@RequestMapping(value="/addEnfantToCommande/{numCommande}",method=RequestMethod.PUT)
	public Client addEnfantToCommande(@RequestBody Enfant e,@PathVariable ("numCommande") Long numCommande)
	{
		//Enfant enfant = enfantRepository.save(e);
		Client Client = (Client) clientRepository.findOne(numclient);
		Client.getListEnfant().add(enfant);
		return clientRepository.save(Client); 
	}*/
	
}
