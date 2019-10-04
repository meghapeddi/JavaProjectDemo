package com.lti.online.exam.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayScoreServlet
 */
@WebServlet("/DisplayScoreServlet")
public class DisplayScoreServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stu
		HttpSession session = request.getSession();
		Integer score = (Integer) session.getAttribute("score");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<h1>");
		out.print("Congratulations !! Your score is ");
		out.print(score+"</h1>");
		
	}

}
