package com.wlochynski.learnish.services;

import java.util.List;

import com.wlochynski.learnish.model.Word;
import com.wlochynski.learnish.model.Word.Category;


public interface WordService {
	void saveWord(Word word);
	int countByCategory(Category category);
	int countAll();
	List<Word> findAllByCategory(Category category);
	List<Word> getWordsToLearnByCategory(Category category, int userId);
	List<Word> getSavedWords(int userId);
}
