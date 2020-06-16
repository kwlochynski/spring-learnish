package com.wlochynski.learnish.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.learnish.dto.WordDTO;
import com.wlochynski.learnish.model.SavedWord;
import com.wlochynski.learnish.repositories.SavedWordRepository;
import com.wlochynski.learnish.services.SavedWordService;

@Service("savedWordService")
@Transactional
public class SavedWordServiceImpl implements SavedWordService {

	@Autowired
	SavedWordRepository savedWordRepository;
	
	@Override
	public void save(SavedWord savedWord)
	{
		savedWordRepository.save(savedWord);
	}
	
	@Override
	public long countByUserId(int userId)
	{
		return savedWordRepository.countByUserId(userId);
	}
	
	@Override
	public List<WordDTO> listOfProgress(int userId)
	{
		return savedWordRepository.listOfProgress(userId);
	}
}
