package com.headshot.jakartaservlettry;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SimpleGenericServletTry
 */
public class SimpleGenericServletTry extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see GenericServlet#GenericServlet()
	 */
	public SimpleGenericServletTry() {
		super();
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContentType()).append(System.lineSeparator())
		.append("ContextInitParam : ").append(getServletContext().getInitParameter("globalkey")).append(System.lineSeparator())
		.append("ServletInitParam : ").append(getInitParameter("key"));
	}

}
