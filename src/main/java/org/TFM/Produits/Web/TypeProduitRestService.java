package org.TFM.Produits.Web;

import java.util.ArrayList;

import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.TypeProduit;
import org.TFM.Produits.DAO.TypeProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TypeProduitRestService{
	@Autowired 
	TypeProduitRepository typeProduitRepository;
	@RequestMapping(value="/typeProduits",method=RequestMethod.GET)
	public ArrayList<TypeProduit> listAllProduit()
	{
		return (ArrayList<TypeProduit>) typeProduitRepository.findAll(); 
	}

}
