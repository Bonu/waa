package edu.mum.mscs.waa.calculator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet(name="calculator", urlPatterns = { "/calculator.do" })
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
 		String add1 = request.getParameter("add1").trim() ;
		String add2 = request.getParameter("add2").trim();
		String mult1 = request.getParameter("mult1").trim();
		String mult2 = request.getParameter("mult2").trim();

		System.out.println(add1);
		String sum = "";
		String product = "";
		
		// Check for valid inputs....
		try {
			int a1 = Integer.parseInt(add1);
			int a2 = Integer.parseInt(add2);
			sum = "" + (a1+a2);
		} catch(NumberFormatException e) {
			if (add1.isEmpty()) add1 = "''";
			if (add2.isEmpty()) add2 = "''";
			sum = "''";
		}
		
		try {
			int a3 = Integer.parseInt(mult1);
			int a4 = Integer.parseInt(mult2);
			product = "" + (a3*a4);
		} catch(NumberFormatException e) {
			if (add1.isEmpty()) add1 = "''";
			if (add2.isEmpty()) add2 = "''";
			sum = "''";
		}
		request.setAttribute("add1", add1);
		request.setAttribute("add2", add2);
		request.setAttribute("mult1", mult1);
		request.setAttribute("mult2", mult2);
		request.setAttribute("sum", sum);
		request.setAttribute("product", product);
		System.out.println("sum->"+sum);
		System.out.println("sum->"+request.getAttribute("sum"));
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/result.jsp");
		view.forward(request, response);
		
	}

}
