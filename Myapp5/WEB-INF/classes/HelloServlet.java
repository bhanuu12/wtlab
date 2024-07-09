import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the user's name from the request
        String name = request.getParameter("name");

        // Create a session
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("startTime", new Date());

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate the response
        out.println("<html><head><title>Hello</title></head><body>");
        out.println("<div style='float: right;'>Start Time: " + new Date() + "</div>");
        out.println("<h1>Hello, " + name + "!</h1>");
        out.println("<form action='logout' method='post'><input type='submit' value='Logout'></form>");
        out.println("</body></html>");
    }
}
