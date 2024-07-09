import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session
        HttpSession session = request.getSession(false);

        // Get the user's name and start time from the session
        String name = (String) session.getAttribute("name");
        Date startTime = (Date) session.getAttribute("startTime");

        // Calculate the duration
        Date endTime = new Date();
        long duration = (endTime.getTime() - startTime.getTime()) / 1000;

        // Invalidate the session
        session.invalidate();

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate the response
        out.println("<html><head><title>Logout</title></head><body>");
        out.println("<h1>Thank You, " + name + "!</h1>");
        out.println("<p>Duration of usage: " + duration + " seconds</p>");
        out.println("</body></html>");
    }
}
