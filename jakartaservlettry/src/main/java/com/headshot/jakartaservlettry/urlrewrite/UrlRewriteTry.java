package com.headshot.jakartaservlettry.urlrewrite;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UrlRewriteTry
 */
public class UrlRewriteTry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UrlRewriteTry() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String abc = request.getQueryString();
		/*if abc is null means first time accessing resource, 
		 * create session store at server side
		 * in next request client can pass it in queryparams
		 */
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("shared sessioninfo :")
				.append(abc);
	}

}
