package stcurr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BenefitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String[] benefitNames = request.getParameterValues("benefit");
        if (benefitNames == null) {
        	RequestDispatcher rd = request.getRequestDispatcher("badinput.html");
        	rd.forward(request, response);
        }
        else {
	        for (String benefit : benefitNames) {
	            if (benefit.equals("holiday")) {
	                RequestDispatcher rd = request.getRequestDispatcher("company.jsp");
	                rd.include(request, response);
	                continue;
	            }
	            if (benefit.equals("health")) {
	                RequestDispatcher rd = request.getRequestDispatcher("health.jsp");
	                rd.include(request, response);
	                continue;
	            }
	            if (benefit.equals("vision")) {
	                RequestDispatcher rd = request.getRequestDispatcher("vision.jsp");
	                rd.include(request, response);
	                continue;
	            }
	            if (benefit.equals("dental")) {
	                RequestDispatcher rd = request.getRequestDispatcher("dental.jsp");
	                rd.include(request, response);
	                continue;
	            }
	        }
        }
        out.print("<HR><BR><BR><A HREF='./welcome.html'>Back To Home Page</A><BR>");
        out.close();
	}

}
