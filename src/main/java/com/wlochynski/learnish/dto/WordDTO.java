package com.wlochynski.learnish.dto;

import com.wlochynski.learnish.model.Word.Category;

public class WordDTO {
	private Category category;
	private long numberOfWords;
	private long numberOfSavedWords;
	
	public WordDTO(Category category, long numberOfWords, long numberOfSavedWords) {
		super();
		this.category = category;
		this.numberOfWords = numberOfWords;
		this.numberOfSavedWords = numberOfSavedWords;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public long getNumberOfWords() {
		return numberOfWords;
	}
	public void setNumberOfWords(long numberOfWords) {
		this.numberOfWords = numberOfWords;
	}
	public long getNumberOfSavedWords() {
		return numberOfSavedWords;
	}
	public void setNumberOfSavedWords(long numberOfSavedWords) {
		this.numberOfSavedWords = numberOfSavedWords;
	}



	
	
}
