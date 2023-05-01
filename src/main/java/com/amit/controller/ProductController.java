package com.amit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amit.entity.Product;
import com.amit.repository.ProductRepo;

@Controller
public class ProductController {

	@Autowired
	private ProductRepo repo;

	@GetMapping("/delete")
	public String deleteData(Integer pid, Model model) {
		repo.deleteById(pid);
		model.addAttribute("msg", "Product deleted");
		model.addAttribute(repo.findAll());
		return "data";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("pid") Integer pid, Model model) {
		Optional<Product> findById = repo.findById(pid);
		if (findById.isPresent()) {
			Product product = findById.get();
			model.addAttribute(product);
		}
		return "index";
	}

	@PostMapping("/product")
	public String saveData(@Validated @ModelAttribute("product") Product product, BindingResult result, Model model) {

		if (result.hasErrors())
			return "index";
		product = repo.save(product);
		if (product.getPid() != null) {
			model.addAttribute("msg", "Product Saved");
		}
		return "index";
	}

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}

	@GetMapping("/products")
	public String getData(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("products", repo.findAll());
		return "data";
	}
}