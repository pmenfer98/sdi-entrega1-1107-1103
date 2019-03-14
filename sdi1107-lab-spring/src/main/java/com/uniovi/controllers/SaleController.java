package com.uniovi.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uniovi.entities.Sale;
import com.uniovi.entities.User;
import com.uniovi.entities.types.SaleStatus;
import com.uniovi.services.SalesService;
import com.uniovi.services.UsersService;
import com.uniovi.validators.SaleValidator;

@Controller
public class SaleController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private SaleValidator saleValidator;

    @Autowired
    private UsersService usersService;

    @GetMapping("/sale/add")
    public String register(Model model) {
	model.addAttribute("sale", new Sale());
	return "sale/add";
    }

    @PostMapping("/sale/add")
    public String registerPost(@Validated Sale sale, BindingResult result,
	    Principal principal) {
	saleValidator.validate(sale, result);
	if (result.hasErrors()) {
	    return "sale/add";
	}
	System.out.println("Sale: " + sale.getTitle() + "**********************************");
	System.out.println("Details: " + sale.getDetails() + "**********************************");
	System.out.println("Price: " + sale.getPrice() + "**********************************");
	User user = usersService.getUserByEmail(principal.getName());
	salesService.add(sale, user);
	return "redirect:list";
    }

    @GetMapping("/sale/list")
    public String list(Model model, Principal principal) {
	User user = usersService.getUserByEmail(principal.getName());
	model.addAttribute("sales", salesService.findByIdAndStatus(user, SaleStatus.ON_SALE));
	return "sale/list";
    }

    @GetMapping("/sale/delete/{id}")
	public String delete(@PathVariable Long id) {
		salesService.delete(id);
		return "redirect:/sale/list";
	}
    
}
