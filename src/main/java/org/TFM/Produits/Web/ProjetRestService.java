package org.TFM.Produits.Web;

import java.util.ArrayList;
import org.TFM.Produits.Entities.Projet;
import org.TFM.Clients.Entities.Client;
import org.TFM.Clients.Entities.Enfant;
import org.TFM.Produits.DAO.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ProjetRestService{
	@Autowired 
	ProjetRepository ProjetRepository;
	@RequestMapping(value="/projets",method=RequestMethod.GET)
	public ArrayList<Projet> listAllProduit()
	{
		return (ArrayList<Projet>) ProjetRepository.findAll(); 
	}
	
	

}
