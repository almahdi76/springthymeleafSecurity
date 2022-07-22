package com.AKA.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.AKA.project.dao.ProduitRepository;
import com.AKA.project.entities.Produit;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		
		ApplicationContext cxt=SpringApplication.run(ProjectApplication.class, args);
		ProduitRepository produitRepository=cxt.getBean(ProduitRepository.class);
//		produitRepository.save(new Produit("Xiaomi S9",250,15));
//		produitRepository.save(new Produit("Samsung S12",1500,30));
//		produitRepository.save(new Produit("OPPO 12",450,11));
//		produitRepository.save(new Produit("LG 60",700,90));
//		produitRepository.save(new Produit("appel S11",1100,60));
//		produitRepository.save(new Produit("Hawawi",555,33));
//		produitRepository.save(new Produit("OPPO A50",660,17));
//		produitRepository.save(new Produit("Nokia GX",800,14));
//		produitRepository.save(new Produit("Xiaom S10",220,99));
//		
//		produitRepository.save(new Produit("LG 15",444,60));
//		produitRepository.save(new Produit("LG xtx",328,47));
//		produitRepository.save(new Produit("Weeky A50",808,17));
//		produitRepository.save(new Produit("Phon 10",800,14));
//		produitRepository.save(new Produit("Plackpery",1000,99));
//		
//		produitRepository.save(new Produit("Xiaomi S9",250,15));
//		produitRepository.save(new Produit("Samsung S12",1500,30));
//		produitRepository.save(new Produit("OPPO 12",450,11));
//		produitRepository.save(new Produit("LG 60",700,90));
//		produitRepository.save(new Produit("appel S11",1100,60));
//		produitRepository.save(new Produit("Hawawi",555,33));
//		produitRepository.save(new Produit("OPPO A50",660,17));
//		produitRepository.save(new Produit("Nokia GX",800,14));
//		produitRepository.save(new Produit("Xiaom S10",220,99));
		produitRepository.findAll().forEach(p -> System.out.println(p.getDesignation()));
		
		
		
		
		
		
		
	}

}
