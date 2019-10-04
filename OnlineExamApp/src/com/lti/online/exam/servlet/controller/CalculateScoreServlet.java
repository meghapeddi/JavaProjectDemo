package com.lti.online.exam.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.online.exam.model.Option;
import com.lti.online.exam.model.Question;

/**
 * Servlet implementation class CalculateScoreServlet
 */
@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int optionNo = Integer.parseInt(request.getParameter("option"));
//		int isComplete = Integer.parseInt(request.getParameter("btn"));

		HttpSession session = request.getSession();
		Question q = (Question) session.getAttribute("currentQuestion");

		// int score = 0;
		Integer score = (Integer) session.getAttribute("score");
		if (score == null)
			score = 0;
		Option selectedOption = q.getOptions().get(optionNo);
		if (selectedOption.isRightAnswer()){
			score++;
		}		
		session.setAttribute("score", score);
		response.sendRedirect("QuestionLoaderServlet");
		/*if(isComplete == 0){
			response.sendRedirect("QuestionLoaderServlet");
		}else{
			response.sendRedirect("DisplayScoreServlet");
		}*/
	}
}
