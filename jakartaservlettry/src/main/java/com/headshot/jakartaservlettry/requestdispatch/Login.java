package com.headshot.jakartaservlettry.requestdispatch;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher rd = null;
		PrintWriter pw = response.getWriter();
		String unm = request.getParameter("username");
		String pwd = request.getParameter("password");
		if (unm != null && pwd != null) {
			if (unm.equals("headshot") && pwd.equals("pwd")) {
				rd = request.getRequestDispatcher("Welcome");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("index.html");
				pw.print("Served at: ");
				pw.print(request.getContextPath());
				pw.print("</br>Invalid credentials");
				rd.include(request, response);
			}
		}
	}
}
