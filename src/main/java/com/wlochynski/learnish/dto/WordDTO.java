package com.wlochynski.learnish.dto;

public class WordDTO {
	private String wordName;

	private String wordTranslation;

	private String wordRead;
	
	private boolean ifSaved;

	public WordDTO(String wordName, String wordTranslation, String wordRead, boolean ifSaved) {
		this.wordName = wordName;
		this.wordTranslation = wordTranslation;
		this.wordRead = wordRead;
		this.ifSaved = ifSaved;
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

	public boolean isIfSaved() {
		return ifSaved;
	}

	public void setIfSaved(boolean ifSaved) {
		this.ifSaved = ifSaved;
	}
	
	
}
