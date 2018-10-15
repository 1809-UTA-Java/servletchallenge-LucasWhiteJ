package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.model.Customer;
import com.revature.repository.CustomerDao;
import com.revature.service.CustomerService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerDao dao = new CustomerDao();
	CustomerService aService = new CustomerService(dao);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();

		resp.setContentType("text");
		PrintWriter pw = resp.getWriter();

		List<Customer> customers = aService.getCustomers();
		ObjectMapper om = new XmlMapper();
		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		// pw.println(userName);
		// pw.println(password);
		for (Customer a : customers) {
			if (path == null || path.equals("/")) {
				if (a.getCustUserName().equals(userName)) {
					if (a.getCustPassword().equals(password)) {
						// String obj = om.writeValueAsString(customers);
						pw.println(a.getCustID() + a.getCustName() + a.getCustUserName() + a.getCustPassword());
					}
				}
			}
		}

		String[] pathSplits = path.split("/");

		if (pathSplits.length != 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
 *      response)
 *
 *      protected void doGet(HttpServletRequest request, HttpServletResponse
 *      response) throws ServletException, IOException { // TODO Auto-generated
 *      method stub
 *      response.getWriter().append("Served at: ").append(request.getContextPath());
 *      }
 * 
 *      /**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
 *      response)
 *
 *      protected void doPost(HttpServletRequest request, HttpServletResponse
 *      response) throws ServletException, IOException { // TODO Auto-generated
 *      method stub doGet(request, response); }
 */
