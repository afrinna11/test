

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GreetingServlet
 */
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the name from the form
        String name = request.getParameter("name");

        // Set response content type
        response.setContentType("text/html");

        // Output a greeting
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Greeting</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Hello, " + name + "!</h2>");
        response.getWriter().println("<a href='index.jsp'>Go Back</a>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
