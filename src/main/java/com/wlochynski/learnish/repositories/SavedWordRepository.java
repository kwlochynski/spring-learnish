package com.wlochynski.learnish.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wlochynski.learnish.dto.WordDTO;
import com.wlochynski.learnish.model.SavedWord;

@Transactional
@Repository("savedWordRepository")
public interface SavedWordRepository extends JpaRepository<SavedWord, Integer>{
	long countByUserId(int userId);
	
	
	@Query("SELECT new com.wlochynski.learnish.dto.WordDTO(w.category, count(w.wordId) as numberOfWords, count(CASE WHEN s.userId =:userId THEN 1 END) as numberOfSavedWords) "
			+ "FROM SavedWord s RIGHT JOIN com.wlochynski.learnish.model.Word w on s.wordId = w.wordId GROUP BY w.category")
	List<WordDTO> listOfProgress(int userId);
	
	@Modifying
	@Query("DELETE FROM SavedWord WHERE wordId =:wordId and userId =:userId")
	void deleteByWordIdByUserId(@Param("wordId") int wordId, @Param("userId") int userId);
	
	}

	
