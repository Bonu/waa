package mum.edu.cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.data.*;
 
/**
 * Servlet implementation class AdviceServlet
 */
public class AdviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdviceServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/advice.jsp");
		requestDispatcher.forward(request, response);

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext ctx = request.getServletContext();
		DataFacade data = (DataFacade) getServletContext().getAttribute("dataSource");
		
		String roast = request.getParameter("roast");		
		
 		List<String> advice = data.getAdvice(roast);

		request.setAttribute("roastList", advice);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/display.jsp");
		requestDispatcher.forward(request, response);

	}

}
