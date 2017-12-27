 package org.TFM;

import java.sql.Date;

import org.TFM.Produits.Entities.Produit;
import org.ilisi.clients.dao.EnfantRepository;
import org.TFM.Clients.DAO.ClientRepository;
import org.TFM.Produits.DAO.ProduitRepository;
import org.TFM.Produits.DAO.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo7Application implements CommandLineRunner{
	@Autowired
	private ClientRepository clientRepository;
	private ProduitRepository produitRepository;
	private PromotionRepository promotionRepository;
	public static void main(String[] args) {
		SpringApplication.run(Demo7Application.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		clientRepository.
		
	}
}
