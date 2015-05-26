package mum;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MyServletParm
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "Hello %s";
		String name = request.getParameter("name");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>Hello world day 1</title></head>");
		writer.println("<body>");
		writer.println("<form method='post'>");
		writer.println("<input name='name'/>");
		writer.println("<input type='submit' name='Press'/>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.println(String.format(message, name));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
