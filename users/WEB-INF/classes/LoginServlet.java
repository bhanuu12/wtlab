import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.Enumeration; // Add this import statement

public class LoginServlet extends HttpServlet {
    public void init() throws ServletException {
        // No specific initialization needed, init parameters are accessed in the service method
    }

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Set response content type
        res.setContentType("text/html");
        
        // Get PrintWriter object
        PrintWriter pw = res.getWriter();
        
        // Read form data
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Get init parameters
        ServletConfig config = getServletConfig();
        Enumeration<String> initParams = config.getInitParameterNames();
        boolean authenticated = false;
        
        while (initParams.hasMoreElements()) {
            String user = initParams.nextElement();
            String pass = config.getInitParameter(user);

            if (username.equals(user) && password.equals(pass)) {
                authenticated = true;
                break;
            }
        }

        // Check authentication and generate appropriate response
        if (authenticated) {
            pw.println("<font color='green' size='4'>Welcome " + username + " to this site</font>");
        } else {
            pw.println("<font color='red' size='4'>You are not an authenticated user</font>");
        }

        // Add hyperlink to the login page
        pw.println("<br><br><a href='index.jsp'>back</a>");
        
        // Close the stream
        pw.close();
    }
}
