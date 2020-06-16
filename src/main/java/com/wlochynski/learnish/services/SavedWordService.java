package com.wlochynski.learnish.services;

import java.util.List;

import com.wlochynski.learnish.dto.WordDTO;
import com.wlochynski.learnish.model.SavedWord;

public interface SavedWordService {

	void save(SavedWord savedWord);

	long countByUserId(int userId);

	List<WordDTO> listOfProgress(int userId);
	
	void delete(int wordId, int userId);

}
