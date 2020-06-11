package com.wlochynski.learnish.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wordTable")
public class Word {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "wordId")
	private int wordId;

	@Column(name = "wordName")
	private String wordName;

	@Column(name = "wordTranslation")
	private String wordTranslation;

	@Column(name = "wordRead")
	private String wordRead;

	@Enumerated(EnumType.STRING)

	@Column(name = "category")
	private Category category;

	public enum Category {
		NOUNS, VERBS, ADJECTIVES, OTHERS
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	public String getWordName() {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public String getWordTranslation() {
		return wordTranslation;
	}

	public void setWordTranslation(String wordTranslation) {
		this.wordTranslation = wordTranslation;
	}

	public String getWordRead() {
		return wordRead;
	}

	public void setWordRead(String wordRead) {
		this.wordRead = wordRead;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
