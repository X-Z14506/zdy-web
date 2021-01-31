package org.example.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-16
 * Time:10:37
 */

@WebServlet("/show-cookies")
public class ShowCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies!=null) {
            for (Cookie cookie:cookies) {
                System.out.print(cookie.getName()+" ");
                System.out.println(cookie.getValue());
                System.out.println("========================");
            }
        }else System.out.println("null cookie");

    }
}
