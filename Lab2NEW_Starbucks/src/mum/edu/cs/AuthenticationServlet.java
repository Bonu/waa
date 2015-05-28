package mum.edu.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.data.DataFacade;
import mum.edu.data.DataFacadeFactory;
import mum.edu.data.TestDataImpl;
/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		writer.println("<!DOCTYPE html>");
		writer.println("<head><meta charset=\"ISO-8859-1\"><title>Insert title here</title></head>");
		writer.println("<body><h2>Ask for advise about your favorite roast</h2><form action=\"../action/advice\" method=\"get\">");
		writer.println("<select name=\"roast\">");
		writer.println("<option value=\"dark\">Dark</option>");
		writer.println("<option value=\"medium\">Medium</option>");
		writer.println("<option value=\"light\">Light</option>");
		writer.println("</select><br/><br/>");
		writer.println("<input type=\"submit\" value=\"Submit\"/><br/><br/>");
		writer.println("</form></body></html>");
*/
		
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("advice.do");

		requestDispatcher.forward(request, response);
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx = request.getServletContext();
		DataFacade data = (DataFacade) getServletContext().getAttribute("dataSource");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		String expectedPassword = data.findPassword(name);
		
		if(expectedPassword == null || !expectedPassword.equals(password)) {
			
				response.sendRedirect("../index.jsp");	
 		
 		} else {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/LoginSuccessful.jsp");
			requestDispatcher.forward(request, response);
 		}
	}

}
