package com.wlochynski.learnish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wlochynski.learnish.model.WordToRepeat;

@Repository("wordToRepeatRepository")
public interface WordToRepeatRepository extends JpaRepository<WordToRepeat, Integer> { 
	
	@Modifying
	@Query("DELETE FROM WordToRepeat WHERE wordId =:wordId and userId =:userId")
	void deleteByUserIdByWordId(@Param("userId") int userId, @Param("wordId") int wordId);
}
