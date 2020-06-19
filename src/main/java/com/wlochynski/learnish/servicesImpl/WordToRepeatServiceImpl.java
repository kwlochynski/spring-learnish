package com.wlochynski.learnish.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.learnish.model.WordToRepeat;
import com.wlochynski.learnish.repositories.WordToRepeatRepository;
import com.wlochynski.learnish.services.WordToRepeatService;

@Service("wordToRepeatService")
@Transactional
public class WordToRepeatServiceImpl implements WordToRepeatService {

	@Autowired
	WordToRepeatRepository wordToRepeatRepository;
	
	@Override
	public void saveWord(WordToRepeat wordToRepeat) {		
		wordToRepeatRepository.save(wordToRepeat);
	}
	
	@Override
	public void deleteByUserIdByWordId(int userId, int wordId)
	{
		wordToRepeatRepository.deleteByUserIdByWordId(userId, wordId);
	}

}
