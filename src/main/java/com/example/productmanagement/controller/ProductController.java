package com.example.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String listProduct(Model model) {
		List<Product> listProduct = productService.listAll();
		model.addAttribute("listProducts", listProduct);
		
		return "index";
	}
	
	@GetMapping("/new")
	public String showNewProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showEditProduct(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = productService.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		productService.delete(id);
		
		return "redirect:/";
	}
}
