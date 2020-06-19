package com.wlochynski.learnish.services;

import com.wlochynski.learnish.model.WordToRepeat;

public interface WordToRepeatService {
	void saveWord(WordToRepeat wordToRepeat);

	void deleteByUserIdByWordId(int userId, int wordId);
}
