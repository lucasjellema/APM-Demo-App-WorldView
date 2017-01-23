package nl.amis.world.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "WorldlyTalk", urlPatterns = { "/worldlytalk" })
public class WorldlyTalk extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>WorldlyTalk</title></head>");
        out.println("<body>");
        out.println("<p>So much to see and do. Get around, meet people, enjoy life</p>");
        out.println("<a href=\"moreworldlytalk\">More Worldly Talk (can be dangerous)</a>");
        out.println("<a href=\"nonexistingservletmoreworldlytalk\">Ephemeral Thoughts (can be hard to get hold of)</a>");
        out.println("<a href=\"superindex.html\">The Application's Main Index</a>");
        out.println("</body></html>");
        out.close();
        request.getServletContext().log("Logging from Servlet WorldlyTalk. Quite urgent. Not.");
    }
}
