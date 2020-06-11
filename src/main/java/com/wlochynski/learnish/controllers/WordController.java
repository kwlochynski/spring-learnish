package com.wlochynski.learnish.controllers;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.learnish.model.Word;
import com.wlochynski.learnish.model.Word.Category;


import com.wlochynski.learnish.services.WordService;

@Controller
public class WordController {

	@Autowired
	WordService wordService;
	
	@GET
	@RequestMapping("/words/{category}")
	public String words(Model model, @PathVariable String category)
	{
		List<Word> listOfWords = wordService.findAllByCategory(Category.valueOf(category));
		Collections.shuffle(listOfWords);
		model.addAttribute("words",listOfWords);
		return "words";
	}
}
