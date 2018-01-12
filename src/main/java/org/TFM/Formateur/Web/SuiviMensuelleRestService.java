package org.TFM.Formateur.Web;

import java.util.ArrayList;
import java.util.List;

import org.TFM.Formateur.DAO.FormateurRepository;
import org.TFM.Formateur.DAO.SuiviMensuelleRepository;
import org.TFM.Formateur.Entities.Formateur;
import org.TFM.Formateur.Entities.SuiviMensuelle;
import org.TFM.Produits.DAO.CompetenceRepository;
import org.TFM.Produits.DAO.ProduitRepository;
import org.TFM.Produits.Entities.AbstractProduit;
import org.TFM.Produits.Entities.Competence;
import org.TFM.Produits.Entities.Pack;
import org.TFM.Produits.Entities.Produit;
import org.TFM.Programe.DAO.GroupeRepository;
import org.TFM.Programe.DAO.SeanceRepository;
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
public class SuiviMensuelleRestService {

	@Autowired
	SuiviMensuelleRepository mensuelleRepository ;
	@Autowired
	FormateurRepository formateurRepository ;

	
	@RequestMapping(value="/AllSuiviOfFormateur/{codeFormateur}",method=RequestMethod.GET)
	public List<SuiviMensuelle> AllSuiviOfFormateur(@PathVariable ("codeFormateur") Long codeFormateur)
	{
		Formateur f = formateurRepository.findOne(codeFormateur); 
		return (List<SuiviMensuelle>) f.getSuivi();
	}
	
	/*  Formateur */
	@RequestMapping(value="/paiementFormateur",method=RequestMethod.PUT)
	public SuiviMensuelle paiementFormateur(@RequestBody SuiviMensuelle f)
	{
		f.setPaiement(true);
		return mensuelleRepository.save(f); 
	}

	
	
}
