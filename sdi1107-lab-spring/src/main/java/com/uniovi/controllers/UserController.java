package com.uniovi.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.User;
import com.uniovi.services.SecurityService;
import com.uniovi.services.UsersService;
import com.uniovi.validators.SignUpFormValidator;

@Controller
public class UserController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private SignUpFormValidator signUpFormValidator;

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}


	@GetMapping("/home")
	public String home(Model model, Principal principal) {
	    	model.addAttribute("money", usersService.findByEmail(principal.getName()).getMoney());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersService.getUserByEmail(email);
		model.addAttribute("markList", activeUser);
		return "home";
	}

	@GetMapping("/signup")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/signup")
	public String registerPost(@Validated User user, BindingResult result, Model model) {
		signUpFormValidator.validate(user, result);
		if (result.hasErrors()) {
			return "signup";
		}
		usersService.addUser(user);
		securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());
		return "redirect:home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loguot(Model model) {
		return "logout";
	}


	@GetMapping("/user/list")
	public String list(Model model, Principal principal) {
	    	model.addAttribute("money", usersService.findByEmail(principal.getName()).getMoney());
		model.addAttribute("usersList", usersService.findValidStandardUser());
		return "/user/list";
	}

	@PostMapping("/user/list")
	public String delete(@RequestParam List<Long> idsUser) {
		for (Long id : idsUser) {
			usersService.deleteUser(id);
		}
		return "redirect:/user/list";
	}
}
