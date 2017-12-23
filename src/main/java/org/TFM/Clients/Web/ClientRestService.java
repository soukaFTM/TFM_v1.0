package org.TFM.Clients.Web;

import java.util.ArrayList;

import org.TFM.Clients.DAO.ClientRepository;
import org.TFM.Clients.DAO.EnfantRepository;
import org.TFM.Clients.Entities.Client;
import org.TFM.Clients.Entities.ClientMoral;
import org.TFM.Clients.Entities.ClientPhysique;
import org.TFM.Clients.Entities.Enfant;
import org.TFM.Commande.DAO.CommandeRepository;
import org.TFM.Commande.Entities.Commande;
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

public class ClientRestService {
	@Autowired 
	ClientRepository clientRepository;
	@Autowired
	EnfantRepository enfantRepository ;
	@Autowired
	CommandeRepository commandeRepository;


	/************** traitement des Client Physique *********************/
	
	@RequestMapping(value="/PageClientPhysique",method=RequestMethod.GET)
	public Page<Client> listPageClientPhysique(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		return clientRepository.findPageClientPhysique(new PageRequest(page,size)); 
	}	
	@RequestMapping(value="/AllClientPhysique",method=RequestMethod.GET)
	public ArrayList<Client> listAllClientPhysique()
	{
		return (ArrayList<Client>) clientRepository.findClientPhysique(); 
	}
	@RequestMapping(value="/saveClientPhysique",method=RequestMethod.POST)
	public ClientPhysique saveClientPhysique(@RequestBody ClientPhysique p)
	{
		return clientRepository.save(p); 
	}	
	
/************** traitement des Client Moral *********************/
	
	@RequestMapping(value="/PageClientMoral",method=RequestMethod.GET)
	public Page<Client> listPageClientMoral(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		return clientRepository.findPageClientMoral(new PageRequest(page,size)); 
	}	
	@RequestMapping(value="/AllClientMoral",method=RequestMethod.GET)
	public ArrayList<Client> listAllClientMoral()
	{
		return (ArrayList<Client>) clientRepository.findClientMoral(); 
	}
	@RequestMapping(value="/saveClientMoral",method=RequestMethod.POST)
	public ClientMoral saveClientMoral(@RequestBody ClientMoral p)
	{
		return clientRepository.save(p); 
		
	}	
	
	/*
 @RequestMapping(value="/addCommandeToClient/{codeCommande}",method=RequestMethod.PUT)
	public Client addCommandeToClient(@RequestBody ClientPotentiel client,@PathVariable ("numcmd") Long numcmd)
	{
		Client ClientPotentiel = (Client) clientRepository.findOne(numclient);
		ClientPotentiel.getListClientPotentiel().add(client);
		return clientRepository.save(ClientPotentiel); 
		
	}*/
/*@RequestMapping(value="/removeClientPotentielFromClient/{numclient}",method=RequestMethod.PUT)
	public Client removeClientPotentielFromClient(@RequestBody Client clientAsupp,@PathVariable ("numclient") Long numclient)
	{
		Client ClientPotentiel = (Client) clientRepository.findOne(numclient);
		for (AbstractClientPotentiel p : ClientPotentiel.getListClientPotentiel()) {
			if(p.getNumClientPotentiel()==clientAsupp.getNumClientPotentiel())
			{
				ClientPotentiel.getListClientPotentiel().remove(p);
				return clientRepository.save(ClientPotentiel); 
			}
		}
		return clientRepository.save(ClientPotentiel); 
	}*/
	
	
	/****************** Traitement commun *********************/
	@RequestMapping(value="/PageClient",method=RequestMethod.GET)
	public Page<Client> listPageClient(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		return clientRepository.findPageClient(new PageRequest(page,size)); 
	}	
	@RequestMapping(value="/AllClient",method=RequestMethod.GET)
	public ArrayList<Client> listAllClient()
	{
		return (ArrayList<Client>) clientRepository.findClient(); 
	}
	@RequestMapping(value="/Client/{numClient}",method=RequestMethod.DELETE)
	public void deleteClient(@PathVariable ("numClient") Long numClient)
	{
	   clientRepository.delete(numClient); 
	}

	@RequestMapping(value="/addEnfantToClient/{numClient}",method=RequestMethod.PUT)
	public Client addEnfantToClient(@RequestBody Enfant e,@PathVariable ("numClient") Long numclient)
	{


		Enfant enfant = enfantRepository.save(e);
		Client Client = (Client) clientRepository.findOne(numclient);
		Client.getListEnfant().add(enfant);
		return clientRepository.save(Client); 
	}
	
	/*@RequestMapping(value="/addCommandeToClient/{numClient}",method=RequestMethod.PUT)
	public Client addCommandeToClient(@RequestBody Commande c,@PathVariable ("numClient") Long numclient)
	{
		Commande commande = commandeRepository.save(c);
		Client Client = (Client) clientRepository.findOne(numclient);
		Client.getListCommande().add(commande);
		return clientRepository.save(Client); 
	}*/
}
