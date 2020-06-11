package com.wlochynski.learnish.services;

import java.util.List;

import com.wlochynski.learnish.model.Word;
import com.wlochynski.learnish.model.Word.Category;


public interface WordService {
	public void saveWord(Word word);
	public int countByCategory(Category category);
	public List<Word> findAllByCategory(Category category);
}
