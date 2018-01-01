package org.TFM.Produits.Web;

import org.TFM.Produits.Entities.Produit;
import org.TFM.Produits.Entities.Promotion;
import org.TFM.Produits.DAO.PromotionRepository;
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
public class PromotionRestService {
	@Autowired 
	PromotionRepository promotionRepository;
	
	@RequestMapping(value="/promotions",method=RequestMethod.GET)
	public Page<Promotion> listPromotion(
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="2")int size)
	{
		return promotionRepository.findAll(new PageRequest(page,size)); 
	}
	
	@RequestMapping(value="/promotion/{codePromo}",method=RequestMethod.GET)
	public Promotion getPromotion(@PathVariable ("codePromo") Long numProduit)
	{
		return promotionRepository.findOne(numProduit); 
	}
	
	@RequestMapping(value="/savePromotion",method=RequestMethod.POST)
	public Promotion savePromotion(@RequestBody Promotion p)
	{
		Promotion promo = promotionRepository.findOne(p.getCodePromo());
		if(promo!=null)
		{
			promo.setDescription(p.getDescription());
			promo.setTaux(p.getTaux());
			promo.setDateDebut(p.getDateDebut());
			promo.setDateFin(p.getDateFin());
			promo.setIntituler(p.getIntituler());
			return promotionRepository.saveAndFlush(promo); 
		}
		return promotionRepository.save(p); 

	}
	
	@RequestMapping(value="/addProduitToPromotion/{codePromo}",method=RequestMethod.PUT)
	public Promotion addProduitToPromotion(@RequestBody Produit produit,@PathVariable ("codePromo") Long codePromo)
	{
		Promotion promotion = promotionRepository.findOne(codePromo);
		promotion.getListeProduit().add(produit);
		return promotionRepository.save(promotion); 
		
	}
	@RequestMapping(value="/removeProduitFromPromotion/{codePromo}",method=RequestMethod.PUT)
	public Promotion removeProduitFromPromotion(@RequestBody Produit produit,@PathVariable ("codePromo") Long codePromo)
	{
		Promotion promotion = promotionRepository.findOne(codePromo);
		for (AbstractProduit p : promotion.getListeProduit()) {
			if(p.getNumProduit()==produit.getNumProduit())
			{
				promotion.getListeProduit().remove(p);
				return promotionRepository.save(promotion); 
			}
		}
		return promotionRepository.save(promotion); 
	}
	
	/*@RequestMapping(value="/promotion/{codePromo}",method=RequestMethod.PUT)
	public Promotion updatePromotion(@RequestBody Promotion p,@PathVariable ("codePromo") Long codePromo)
	{
		p.setCodePromo(codePromo);
		return promotionRepository.saveAndFlush(p); 
	}
	*/
	@RequestMapping(value="/promotion/{codePromo}",method=RequestMethod.DELETE)
	public void deletePromotion(@PathVariable ("codePromo") Long codePromo)
	{
	   promotionRepository.delete(codePromo); 
	}
	
}
