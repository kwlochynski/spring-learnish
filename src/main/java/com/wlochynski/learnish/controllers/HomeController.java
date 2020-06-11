package com.wlochynski.learnish.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.learnish.model.Word;
import com.wlochynski.learnish.services.WordService;
import com.wlochynski.learnish.model.Word.Category;

@Controller
public class HomeController {

	@Autowired
	WordService wordService;

	@GET
	@RequestMapping(value = { "/", "/index" })
	public String mainPage(Model model) throws FileNotFoundException {

		/*
		 * Scanner s = new Scanner(new
		 * File("C:/Users/kwloc/OneDrive/Desktop/LearnSpanish/CZASOWNIKI.txt")); while
		 * (s.hasNextLine()) { Word word = new Word(); String line = s.nextLine();
		 * word.setWordName( line.substring(0, line.indexOf("-") - 1));
		 * word.setWordTranslation(line.substring(line.indexOf("-") + 2,
		 * line.indexOf("[") - 1)); word.setWordRead(line.substring(line.indexOf("[")));
		 * word.setCategory(Word.Category.VERBS); wordService.saveWord(word); }
		 * s.close();
		 */

		model.addAttribute("nouns", wordService.countByCategory(Category.NOUNS));
		model.addAttribute("verbs", wordService.countByCategory(Category.VERBS));
		model.addAttribute("adjectives", wordService.countByCategory(Category.ADJECTIVES));
		model.addAttribute("others", wordService.countByCategory(Category.OTHERS));


		return "index";
	}
}
