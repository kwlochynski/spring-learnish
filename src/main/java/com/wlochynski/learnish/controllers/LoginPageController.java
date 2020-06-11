package com.wlochynski.learnish.controllers;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.learnish.model.User;

@Controller
public class LoginPageController {
	@GET
	@RequestMapping(value = "/login")
	public String showLoginPage(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		return "login";
	}
}