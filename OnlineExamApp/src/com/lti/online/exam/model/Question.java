package com.lti.online.exam.model;

import java.util.List;

public class Question {
	private String question;
	private List<Option> options; // why we used strings is that the number of the option may vary
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
}
