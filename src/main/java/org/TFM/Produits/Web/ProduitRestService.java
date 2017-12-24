package org.TFM.Produits.Web;

import java.util.ArrayList;

import org.TFM.Produits.Entities.*;
import org.TFM.Produits.DAO.ProduitRepository;
import org.TFM.Produits.Entities.AbstractProduit;
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
public class ProduitRestService {
	@Autowired 
	ProduitRepository produitRepository;
	
	/******* simple Produit ***********/
	@RequestMapping(value="/PageProduits",method=RequestMethod.GET)
	public Page<Produit> listPageProduit(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		
		return produitRepository.findPageProd(new PageRequest(page,size)); 
	}
	@RequestMapping(value="/AllProduits",method=RequestMethod.GET)
	public ArrayList<Produit> listAllProduit()
	{
		return (ArrayList<Produit>) produitRepository.findProduits(); 
	}
	@RequestMapping(value="/ChercherProduits",method=RequestMethod.GET)
	public Page<Produit> ChercherProduits(String mc,
			
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		return produitRepository.chercherProduits(mc,new PageRequest(page,size)); 
	}
	@RequestMapping(value="/saveProduit",method=RequestMethod.POST)
	public Produit saveProduit(@RequestBody Produit p)
	{
		return produitRepository.save(p); 
	}
	/************** traitement des pack de produit *********************/
	@RequestMapping(value="/PagePack",method=RequestMethod.GET)
	public Page<Pack> listPack(
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		return produitRepository.findPagePack(new PageRequest(page,size)); 
	}	
	@RequestMapping(value="/ChercherPack",method=RequestMethod.GET)
	public Page<Pack> ChercherPack(String mc,
			
		@RequestParam(name="page",defaultValue="0")int page,
		@RequestParam(name="size",defaultValue="5")int size)
	{
		return produitRepository.chercherPack(mc,new PageRequest(page,size)); 
	}
	@RequestMapping(value="/addProduitToPack/{numProd}",method=RequestMethod.PUT)
	public Pack addProduitToPack(@RequestBody Produit prod,@PathVariable ("numProd") Long numProd)
	{
		Pack produit = (Pack) produitRepository.findOne(numProd);
		produit.getListProduit().add(prod);
		return produitRepository.save(produit); 
		
	}
	@RequestMapping(value="/removeProduitFromPack/{numProd}",method=RequestMethod.PUT)
	public Pack removeProduitFromPack(@RequestBody Produit prodAsupp,@PathVariable ("numProd") Long numProd)
	{
		Pack produit = (Pack) produitRepository.findOne(numProd);
		for (AbstractProduit p : produit.getListProduit()) {
			if(p.getNumProduit()==prodAsupp.getNumProduit())
			{
				produit.getListProduit().remove(p);
				return produitRepository.save(produit); 
			}
		}
		return produitRepository.save(produit); 
	}
	@RequestMapping(value="/savePack",method=RequestMethod.POST)
	public Pack saveProduit(@RequestBody Pack p)
	{
		return produitRepository.save(p); 
	}
	/****************** Traitement commun *********************/
	@RequestMapping(value="/produits/{codePromo}",method=RequestMethod.GET)
	public AbstractProduit getProduit(@PathVariable ("codePromo") Long numProduit)
	{
		return produitRepository.findOne(numProduit); 
	}
	@RequestMapping(value="/produits/{numProduit}",method=RequestMethod.DELETE)
	public void deleteProduit(@PathVariable ("numProduit") Long numProduit)
	{
	   produitRepository.delete(numProduit); 
	}
	@RequestMapping(value="/getAllProduits",method=RequestMethod.GET)
	public ArrayList<AbstractProduit> getAllProduits()
	{
		return (ArrayList<AbstractProduit>) produitRepository.findAll(); 
	}
	
	/**********************Competences*****************************/
	
	@RequestMapping(value="/addCompetenceToProduit/{numProd}",method=RequestMethod.PUT)
	public Produit addCompetenceToProduit(@RequestBody Competence comp,@PathVariable ("numProd") Long numProd)
	{
		Produit produit = (Produit) produitRepository.findOne(numProd);
		produit.getListCompetence().add(comp);
		return produitRepository.save(produit); 
		
	}
	@RequestMapping(value="/removeCompetenceFromProduit/{numProd}",method=RequestMethod.PUT)
	public Produit removeCompetenceFromProduit(@RequestBody Competence comp,@PathVariable ("numProd") Long numProd)
	{
		Produit produit = (Produit) produitRepository.findOne(numProd);
		for (Competence c : produit.getListCompetence()) {
			if(c.getCodeCompetence()==comp.getCodeCompetence())
			{
				produit.getListCompetence().remove(c);
				return produitRepository.save(produit); 
			}
		}
		return produitRepository.save(produit); 
	}
	
/**********************Projets*****************************/
	
	@RequestMapping(value="/addProjetToProduit/{numProd}",method=RequestMethod.PUT)
	public Produit addProjetToProduit(@RequestBody Projet projet,@PathVariable ("numProd") Long numProd)
	{
		System.out.println("Projet => "+projet.getIntituler());
		Produit produit = (Produit) produitRepository.findOne(numProd);
		produit.getListProjet().add(projet);
		return produitRepository.save(produit); 
		
	}
	@RequestMapping(value="/removeProjetFromProduit/{numProd}",method=RequestMethod.PUT)
	public Produit removeProjetFromProduit(@RequestBody Projet projet,@PathVariable ("numProd") Long numProd)
	{
		Produit produit = (Produit) produitRepository.findOne(numProd);
		for (Projet p : produit.getListProjet()) {
			if(p.getCodeProjet()==projet.getCodeProjet())
			{
				produit.getListProjet().remove(p);
				return produitRepository.save(produit); 
			}
		}
		return produitRepository.save(produit); 
	}
	
}
