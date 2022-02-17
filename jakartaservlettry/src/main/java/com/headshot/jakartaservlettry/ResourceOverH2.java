package com.headshot.jakartaservlettry;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ResourceOverH2
 */
@WebServlet(value = "/ResourceOverHttp2")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String imageResource = request.getContextPath() + "/batman.jpg";
		PrintWriter pw = response.getWriter();
		PushBuilder pb = request.newPushBuilder();
		if (pb != null) {
			pb.path(imageResource);
			pb.push();
		}
		pw.println("<html>");
		pw.println("<body>");
		pw.append("Served at: ").append(request.getContextPath());
		pw.print("<img src=\"" + imageResource + "\"/>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
