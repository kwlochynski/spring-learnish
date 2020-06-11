package com.wlochynski.learnish.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wlochynski.learnish.model.Word;
import com.wlochynski.learnish.model.Word.Category;

@Repository("wordRepository")
public interface WordRepository extends JpaRepository<Word, Integer>  {
	int countByCategory(Category category);
	List<Word> findAllByCategory(Category category);
}
