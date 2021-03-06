package com.wlochynski.learnish.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wlochynski.learnish.model.Word;
import com.wlochynski.learnish.model.Word.Category;

@Repository("wordRepository")
public interface WordRepository extends JpaRepository<Word, Integer> {
	int countByCategory(Category category);
	
	List<Word> findAllByCategory(Category category);

	/*
	 * @Query("SELECT new com.wlochynski.learnish.dto.WordDTO(w.wordName, w.wordTranslation, w.wordRead, "
	 * +
	 * "CASE WHEN EXISTS (SELECT s.userId from SavedWord s WHERE s.userId = 1 and w.wordId = s.wordId) THEN 'TRUE' ELSE 'FALSE' END AS isSaved) "
	 * +
	 * "FROM Word w LEFT JOIN SavedWord s ON w.wordId = s.wordId where w.category =:category and isSaved = 'FALSE'"
	 * ) public List<WordDTO> wordDTOByCategory(Category category);
	 */
	
	@Query("SELECT w FROM Word w LEFT JOIN SavedWord s ON w.wordId = s.wordId where w.category =:category "
			+ "and NOT EXISTS (SELECT s.userId from SavedWord s WHERE s.userId =:userId and w.wordId = s.wordId) "
			+ "and NOT EXISTS (SELECT wtr.userId from WordToRepeat wtr WHERE wtr.userId =:userId and w.wordId = wtr.wordId)")
	List<Word> getWordsToLearnByCategory(@Param("category") Category category, @Param("userId") int userId);
	
	@Query("SELECT w FROM Word w JOIN SavedWord s ON w.wordId = s.wordId where s.userId =:userId")
	List<Word> getSavedWords(int userId);
	
	@Query("SELECT w FROM Word w JOIN WordToRepeat wtr ON w.wordId = wtr.wordId where wtr.userId =:userId and w.category =:category")
	List<Word> getWordsToRepeatByCategory(@Param("userId") int userId, @Param("category") Category category);

}