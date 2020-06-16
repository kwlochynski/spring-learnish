package com.wlochynski.learnish.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.learnish.model.Word;
import com.wlochynski.learnish.model.Word.Category;
import com.wlochynski.learnish.repositories.WordRepository;
import com.wlochynski.learnish.services.WordService;


@Service("wordService")
@Transactional
public class WordServiceImpl implements WordService {

	@Autowired
	WordRepository wordRepository;
	
	@Override
	public void saveWord(Word word) {
		wordRepository.save(word);
	}

	@Override
	public int countByCategory(Category category) {
		return wordRepository.countByCategory(category);
	}
	
	@Override
	public int countAll() {
		return (int) wordRepository.count();
	}
	
	@Override
	public List<Word> findAllByCategory(Category category) {
		return wordRepository.findAllByCategory(category);
	}

	@Override
	public List<Word> getWordsToLearnByCategory(Category category, int userId) {
		return wordRepository.getWordsToLearnByCategory(category, userId);
	}

	@Override
	public List<Word> getSavedWords(int userId) {
		return wordRepository.getSavedWords(userId);
	}
}
