//package com.headshot.jakartaservlettry;
//
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//
//public class Main {
//
//	public static void main(String[] args) {
//		try {
//			Server server = new Server(8082);
//			ServletContextHandler context = new ServletContextHandler(server, "/jakartaservlettry");
//			context.addServlet(SimpleServlet.class, "/SimpleServlet");
//			context.addServlet(SimpleGenericServletTry.class, "/SimpleGenericServletTry");
//			context.setInitParameter("key", "value in all");
//			server.start();
//			server.join();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
