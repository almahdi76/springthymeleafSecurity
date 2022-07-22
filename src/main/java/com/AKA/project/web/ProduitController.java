package com.AKA.project.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AKA.project.dao.ProduitRepository;
import com.AKA.project.entities.Produit;



@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepository;

	
//	@RequestMapping(value="/index")
//	public String index(Model model) {
//		Pageable pageable = PageRequest.of(0, 4);
//        Page<Produit> pageProducts = produitRepository.findAll(pageable);
//		model.addAttribute("listProduit",pageProducts);
//		return "produits";
//	}
	
//	@RequestMapping(value="/index")
//	public String index(Model model,@RequestParam(name="page", defaultValue="0") int p,@RequestParam(name="size",defaultValue="3") int s) {
//		Pageable pageable = PageRequest.of(p, s);
//        Page<Produit> pageProducts = produitRepository.findAll(pageable);
//		model.addAttribute("listProduit",pageProducts);
//		int pages[]=new int[pageProducts.getTotalPages()];
//		model.addAttribute("pages", pages);
//		model.addAttribute("size", s);
//		model.addAttribute("pageCourant", p);
//		return "produits";
//	}
	
	@RequestMapping(value="/index")
	public String index(Model model,@RequestParam(name="page", defaultValue="0") int p,@RequestParam(name="size",defaultValue="3") int s,
			@RequestParam(name="mc",defaultValue="") String mc) {
		Pageable pageable = PageRequest.of(p, s);
        Page<Produit> pageProducts = produitRepository.chercher("%"+mc+"%",pageable);
		model.addAttribute("listProduit",pageProducts);
		int pages[]=new int[pageProducts.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourant", p);
		model.addAttribute("mc", mc);
		//System.out.println("mc.."+mc);
		model.addAttribute("activePage", "index");
		return "produits";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Long id,String mc,int page,int size) {
		produitRepository.deleteById(id);
		return "redirect:/index?page="+page+"&size="+size+"&mc="+mc;
	}
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String formProduit(Model model) {
		model.addAttribute("produit",new Produit());
		
		return "FormProduit";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,@Valid Produit produit, BindingResult bindingResult ) {
		if(bindingResult.hasErrors())
			return "FormProduit";
		produitRepository.save(produit);
		
		return "Conformation";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String Edit(Model model,Long id) {
		Produit p=produitRepository.findById(id).orElse(null);
		if(p==null) throw new RuntimeException("no trouve");
		model.addAttribute("produit",p);
		model.addAttribute("activePage", "edit");
		return "EditProduit";
	}
}
