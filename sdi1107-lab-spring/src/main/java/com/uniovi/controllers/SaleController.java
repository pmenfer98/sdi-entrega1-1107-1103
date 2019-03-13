package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.services.SalesService;
import com.uniovi.validators.SaleValidator;

@Controller
public class SaleController {

    @Autowired
    private SalesService salesService;
    
    @Autowired
    private SaleValidator saleValidator;
    
    @GetMapping("/sale/add")
    public String register(Model model) {
	model.addAttribute("sale", new Sale());
	return "sale/add";
    }

    @PostMapping("/sale/add")
    public String registerPost(@Validated Sale sale, BindingResult result,
	    Model model) {
	saleValidator.validate(sale, result);
	if (result.hasErrors()) {
	    return "sale/add";
	}
	salesService.add(sale);
	return "redirect:add";
    }
    
}
