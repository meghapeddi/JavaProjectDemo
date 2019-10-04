package com.lti.online.exam.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {
	/*
	 * Alternate way is create a list for all the questions and when a new
	 * subject is there we need to change the whole code
	 * 
	 * TODO :Use set instead if list
	 */
	private Map<Subject, List<Question>> questionBank;

	public QuestionBank() {
		// TODO Auto-generated constructor stub
		questionBank = new HashMap<>();
	}

	public void addNewSubject(Subject subject) {
		questionBank.put(subject, new ArrayList<>());

	}

	public void addNewQuestion(Subject subject, Question question) {
		List<Question> questions = questionBank.get(subject);
		questions.add(question);
	}
	
	public List<Question> getQuestionsFor(Subject subject){
		return questionBank.get(subject);
	}
}
