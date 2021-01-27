package org.example.web.cookie;

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
 * Date:2020-12-05
 * Time:15:21
 */
@WebServlet("/cookieDemo2")
public class cookieDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //3.获取cookie
        Cookie[] cs = request.getCookies();
        //获取数据，遍历cookies
        if (cs != null) {
            for (Cookie c : cs) {
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name +":"+value);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
