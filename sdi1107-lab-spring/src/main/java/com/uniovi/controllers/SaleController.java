package com.uniovi.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String register(Model model, Principal principal) {
	model.addAttribute("money",
		usersService.findByEmail(principal.getName()).getMoney());
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
	User user = usersService.getUserByEmail(principal.getName());
	salesService.add(sale, user);
	return "redirect:list";
    }

    @GetMapping("/sale/list")
    public String list(Model model, Pageable pageable, Principal principal) {
	model.addAttribute("money",
		usersService.findByEmail(principal.getName()).getMoney());
	User user = usersService.getUserByEmail(principal.getName());
	model.addAttribute("sales",
		salesService
			.findByIdAndStatus(pageable, user, SaleStatus.ON_SALE)
			.getContent());
	model.addAttribute("page", salesService.findByIdAndStatus(pageable,
		user, SaleStatus.ON_SALE));

	return "sale/list";
    }

    @GetMapping("/sale/listAll")
    public String listAll(Pageable pageable, Model model, Principal principal,
	    @RequestParam(value = "", required = false) String searchText) {

	User user = usersService.getUserByEmail(principal.getName());
	model.addAttribute("money",
		usersService.findByEmail(principal.getName()).getMoney());
	if (searchText != null && !searchText.isEmpty()) {
	    model.addAttribute("sales",
		    salesService
			    .findBySaleName(pageable, searchText, user.getId())
			    .getContent());
	    model.addAttribute("page", salesService.findBySaleName(pageable,
		    searchText, user.getId()));

	} else {
	    model.addAttribute("sales", salesService
		    .findOthers(pageable, user.getId()).getContent());
	    model.addAttribute("page",
		    salesService.findOthers(pageable, user.getId()));
	}

	return "sale/listAll";
    }

    @GetMapping("/sale/delete/{id}")
    public String delete(@PathVariable Long id) {
	salesService.delete(id);
	return "redirect:/sale/list";
    }

    @GetMapping("/sale/buy/{id}")
    public String buy(@PathVariable Long id, Principal principal) {
	User user = usersService.getUserByEmail(principal.getName());
	Sale sale = salesService.findById(id);
	if (salesService.buy(sale, user)) {
	    return "redirect:/sale/listAll?success";
	}
	return "redirect:/sale/listAll?error";
    }

    @GetMapping("/sale/listOwn")
    public String checkBoughtSales(Pageable pageable, Principal principal,
	    Model model) {
    	model.addAttribute("money", usersService.findByEmail(principal.getName()).getMoney());
	User user = usersService.getUserByEmail(principal.getName());
	String email = user.getEmail();
	model.addAttribute("sales",
		salesService.searchBoughtSales(pageable, email).getContent());
	model.addAttribute("page",
		salesService.searchBoughtSales(pageable, email));
	return "sale/listOwn";

    }

}
