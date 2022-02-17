package com.headshot.jakartaservlettry.http2image;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

/**
 * Servlet implementation class ResourceOverH2
 */
public class ResourceOverH2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResourceOverH2() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		pw.append("Served at: ").append(req.getContextPath());
		System.out.println(getServletContext().getResourcePaths("/"));
		String baseimageResourceUrlFormat = req.getContextPath() + "/images/2years-gophers_%d.jpg";
		pw.append(baseimageResourceUrlFormat);
		System.out.println(baseimageResourceUrlFormat);
		PushBuilder pb = req.newPushBuilder();
		if (pb != null) {
			for (int i = 0; i < 120; i++) {
				pb.path(String.format(baseimageResourceUrlFormat, i));
			}
			pb.push();
		}
		for (int i = 0; i < 120; i++) {
			if(i%10==0) {
				pw.append("</br>");
			}
			pw.append("<img src=\"" + String.format(baseimageResourceUrlFormat, i) + "\"/>");
		}
	}
}
