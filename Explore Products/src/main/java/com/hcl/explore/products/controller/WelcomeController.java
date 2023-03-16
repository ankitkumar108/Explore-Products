package com.hcl.explore.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.explore.products.service.IExploreProductService;

@Controller
public class WelcomeController {

	@Autowired
	private IExploreProductService expProductService;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUserName());
		model.put("products", expProductService.getProductsByUser(getLoggedinUserName()));
		return "welcome";
	}
	@RequestMapping(value = { "/search", "/searchWelcome" }, method = RequestMethod.GET)
	public String showWelcomePage(@RequestParam String search,ModelMap model) {
		model.put("name", getLoggedinUserName());
		model.put("products", expProductService.searchProducts(getLoggedinUserName(), search));
		return "welcome";
	}

	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

}
