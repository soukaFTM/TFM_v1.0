package org.TFM.Programe.Web;

import java.util.ArrayList;

import org.TFM.Commande.DAO.CommandeRepository;
import org.TFM.Commande.Entities.Commande;
import org.TFM.Programe.DAO.GroupeRepository;
import org.TFM.Programe.Entities.Groupe;
import org.TFM.Programe.Entities.Programme;
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

public class ProgrammeRestService {
	@Autowired 
	org.TFM.Programe.DAO.ProgrammeRepository ProgrammeRepository;
	@Autowired
	GroupeRepository groupeRepository ;
	
	@RequestMapping(value="/AllProgramme",method=RequestMethod.GET)
	public ArrayList<Programme> listAllProgramme()
	{
		return (ArrayList<Programme>) ProgrammeRepository.findAll(); 
	}
	@RequestMapping(value="/saveProgramme",method=RequestMethod.POST)
	public Programme saveProgramme(@RequestBody Programme p)
	{
		System.out.println(p.getProduit().getNumProduit());
		return ProgrammeRepository.save(p); 
	}	
	
	@RequestMapping(value="/saveProgrammePack",method=RequestMethod.POST)
	public Programme saveProgrammePack(@RequestBody Programme p)
	{
		System.out.println(p.getProduit().getNumProduit());
		return ProgrammeRepository.save(p); 
	}	
	

	@RequestMapping(value="/PageProgramme",method=RequestMethod.GET)
	public Page<Programme> listPageProgramme(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		return ProgrammeRepository.findPageProgramme(new PageRequest(page,size)); 
	}	
	
	@RequestMapping(value="/Programme/{numProgramme}",method=RequestMethod.DELETE)
	public void deleteProgramme(@PathVariable ("numProgramme") Long numProgramme)
	{
	   ProgrammeRepository.delete(numProgramme); 
	}

	@RequestMapping(value="/addGroupeToProgramme/{numProgramme}",method=RequestMethod.PUT)
	public Programme addGroupeToProgramme(@RequestBody Groupe e,@PathVariable ("numProgramme") Long numProgramme)
	{
		Groupe Groupe = groupeRepository.save(e);
		Programme Programme = (Programme) ProgrammeRepository.findOne(numProgramme);
		Programme.getListGroupe().add(Groupe);
		return ProgrammeRepository.save(Programme); 
	}
	
	
	/*@RequestMapping(value="/addCommandeToProgramme/{numProgramme}",method=RequestMethod.PUT)
	public Programme addCommandeToProgramme(@RequestBody Commande c,@PathVariable ("numProgramme") Long numProgramme)
	{
		Commande commande = commandeRepository.save(c);
		Programme Programme = (Programme) ProgrammeRepository.findOne(numProgramme);
		Programme.getListCommande().add(commande);
		return ProgrammeRepository.save(Programme); 
	}*/
}
