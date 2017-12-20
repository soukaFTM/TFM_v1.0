package org.TFM.Clients.Web;

import java.util.ArrayList;

import org.TFM.Clients.DAO.EnfantRepository;
import org.TFM.Clients.Entities.Client;
import org.TFM.Clients.Entities.Enfant;
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
public class EnfantRestService {
	@Autowired 
	EnfantRepository enfantRepository;
	
	@RequestMapping(value="/PageEnfant",method=RequestMethod.GET)
	public Page<Enfant> listPageEnfant(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		return enfantRepository.findPageEnfant(new PageRequest(page,size)); 
	}
	@RequestMapping(value="/AllEnfants",method=RequestMethod.GET)
	public ArrayList<Enfant> listAllEnfant()
	{
		return (ArrayList<Enfant>) enfantRepository.findEnfant(); 
	}
	@RequestMapping(value="/saveEnfant",method=RequestMethod.POST)
	public Enfant saveEnfant(@RequestBody Enfant p)
	{
		return enfantRepository.save(p); 
	}
	@RequestMapping(value="/enfant/{numEnfant}",method=RequestMethod.DELETE)
	public void deletEnfant(@PathVariable ("numenfant") Long numenfant)
	{
	   enfantRepository.delete(numenfant); 
	}

	/*@RequestMapping(value="/addCommandeToEnfant/{numEnfant}",method=RequestMethod.PUT)
	public Client addEnfantToClient(@RequestBody Commande c,@PathVariable ("numEnfant") Long numEnfant)
	{
		Enfant enfant = enfantRepository.save(e);
		Client Client = (Client) clientRepository.findOne(numclient);
		Client.getListEnfant().add(enfant);
		return clientRepository.save(Client); 
	}*/
	
}
