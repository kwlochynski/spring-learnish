package com.wlochynski.learnish.controllers;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wlochynski.learnish.model.SavedWord;
import com.wlochynski.learnish.utilites.UserUtilites;
import com.wlochynski.learnish.model.Word;
import com.wlochynski.learnish.model.Word.Category;


import com.wlochynski.learnish.services.WordService;
import com.wlochynski.learnish.services.SavedWordService;
import com.wlochynski.learnish.services.UserService;


@Controller
public class WordController {

	@Autowired
	WordService wordService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SavedWordService savedWordService;
	
	
	
	@GET
	@RequestMapping("/words/{category}")
	public String words(Model model, @PathVariable String category)
	{
		List<Word> listOfWords = wordService.getWordsToLearnByCategory(Category.valueOf(category), userService.findUserByEmail(UserUtilites.getLoggedUser()).getUserId());
		Collections.shuffle(listOfWords);
		model.addAttribute("words",listOfWords);
		
		model.addAttribute("allWords",wordService.countByCategory(Category.valueOf(category)));
		
		return "words";
	}
	
	@POST
	@RequestMapping("/saveWord/{wordId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void saveWord(@PathVariable int wordId)
	{
		SavedWord savedWord = new SavedWord();
		savedWord.setUserId(userService.findUserByEmail(UserUtilites.getLoggedUser()).getUserId());
		savedWord.setWordId(wordId);
		savedWordService.save(savedWord);
	}
	
	
	@GET
	@RequestMapping("/savedWords")
	public String savedWords(Model model)
	{
		model.addAttribute("listOfSavedWords",wordService.getSavedWords(userService.findUserByEmail(UserUtilites.getLoggedUser()).getUserId()));

		return "savedWords";
	}
	
	@POST
	@RequestMapping("/deleteWord/{wordId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteWord(@PathVariable int wordId)
	{
		savedWordService.delete(wordId, userService.findUserByEmail(UserUtilites.getLoggedUser()).getUserId());
	}
}
