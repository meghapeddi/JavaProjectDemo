package com.lti.online.exam.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.online.exam.model.Option;
import com.lti.online.exam.model.Question;
import com.lti.online.exam.model.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {

	private List<Question> questions;
	private int noOfQuestions;
	private int questionNo;

	/*
	 * (non-Javadoc) Here we will load the data or questions only once so we
	 * will write it in init method As init method is loaded only once
	 */
	@Override
	public void init() throws ServletException {
		questions = QuestionBankLoader.loadQuestionsOnJava();
		noOfQuestions = questions.size();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/*
		 * questionNo: if you create this as a field then concurrency in code is
		 * not achieved This code will fail if multiple user log in into the
		 * system . A new session is created when we open it into a new browser
		 */
		Integer questionNo = (Integer) session.getAttribute("qNo");
		if (questionNo == null)
			questionNo = 0;
		else
			questionNo++;

		if (questionNo >= noOfQuestions) {
			response.sendRedirect("DisplayScoreServlet");
		} else {
			session.setAttribute("qNo", questionNo);
			session.setAttribute("totalQues", noOfQuestions);
			Question q = questions.get(questionNo);// get is method of list

			/*
			 * we are creating the session and storing the question as it will
			 * become easy to find out for which question the option is
			 * selected.And this data will be passed to the calculator to bind
			 * the question and the answer
			 */
			session.setAttribute("currentQuestion", q);

			/* It is good to mention the type of response to the browser
			 mention in case if the browser
			 doesn't recognise that the
			 response is in html page
			 */			
		
			out.print("<form action = 'CalculateScoreServlet'>");
			out.print("<h3>Question " + (questionNo) + " of " + (noOfQuestions-1 )+ "<h3>");
			out.print("<h3>" + q.getQuestion() + "</h3>");
			int opNo = 0;
			for (Option o : q.getOptions()) {
				out.print("<h4>" + "<input type='radio' name='option' value='" + (opNo++) + "'>" + o.getOption()
						+ "</h4>");

			}
			/*
			 * if (questionNo != noOfQuestions-1) out.
			 * print("<button type = 'submit' value='0' name='btn'>Continue</button>"
			 * ); else out.
			 * print("<button type = 'submit' value='1' name='btn'>Finish</button>"
			 * );
			 */
			if (questionNo == noOfQuestions) {
				out.print("<button type = 'submit' value='0' name='btn'>Submit</button>");
			} else {
				out.print("<button type = 'submit' value='0' name='btn'>Continue</button>");
			}
			out.print("</form>");
		}

	}

}
