package com.lti.online.exam.model;

import java.util.ArrayList;
import java.util.List;

/*
 * this will load questions on the servlet
 */
public class QuestionBankLoader {

	public static List<Question> loadQuestionsOnJava() {
		QuestionBank qb = new QuestionBank();
		Subject s = new Subject();
		s.setName("Java");
		qb.addNewSubject(s);

		Question q = new Question();
		q.setQuestion("What is G1 in java?");

		List<Option> ops = new ArrayList<Option>();
		ops.add(new Option("G1 is garbage collector", true));
		ops.add(new Option("G1 is another name of Jeevan", false));
		ops.add(new Option("G1 is collection", false));
		ops.add(new Option("G1 is name of a spy agency", false));
		q.setOptions(ops);

		qb.addNewQuestion(s, q);

		q = new Question();
		q.setQuestion("What is Inheritance?");

		ops = new ArrayList<Option>();
		ops.add(new Option("The property where the subclass extends the super class", true));
		ops.add(new Option("The super class and subclass have a ", false));
		ops.add(new Option("Inheritance is also used for data hiding", false));
		q.setOptions(ops);

		qb.addNewQuestion(s, q);

		q = new Question();
		q.setQuestion("How can threads be created?");

		ops = new ArrayList<Option>();
		ops.add(new Option("The property where the subclass extends the super class", false));
		ops.add(new Option("By extending the Thread class or the Runnable interface", true));
		ops.add(new Option("Inheritance is also used for data hiding", false));
		q.setOptions(ops);

		qb.addNewQuestion(s, q);

		q = new Question();
		q.setQuestion("Can static class be inherited");
		ops = new ArrayList<Option>();
		ops.add(new Option("True", true));
		ops.add(new Option("False", false));
		q.setOptions(ops);

		qb.addNewQuestion(s, q);

		q = new Question();
		q.setQuestion("Which of these is a process of writing the state of an object to a byte stream?");
		ops = new ArrayList<Option>();
		ops.add(new Option("Serialization", true));
		ops.add(new Option("File Filtering", false));
		ops.add(new Option("Externalization", false));
		ops.add(new Option(" All of the mentioned", false));
		q.setOptions(ops);

		qb.addNewQuestion(s, q);

		return qb.getQuestionsFor(s);

	}
}
