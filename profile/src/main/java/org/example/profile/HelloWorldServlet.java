package org.example.profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-09
 * Time:19:48
 */

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actor = req.getParameter("actor");
        if (actor == null) {
            actor = "jia";
        }
        resp.setContentType("text/plain charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("actor = "+actor);
    }
}
