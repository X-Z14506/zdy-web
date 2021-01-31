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
 * Date:2020-12-15
 * Time:16:24
 */

@WebServlet("/set-cookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这个是设置cookie的最本质方法，但不好用
        resp.setHeader("Set-Cookie","k1=v1");
        //默认情况下的，会话级别的cookie
        Cookie cookie = new Cookie("k3","v3");
        resp.addCookie(cookie);
        //持久化存储的cookie
        Cookie cookie1 = new Cookie("k4","v4");
        cookie1.setMaxAge(300);
        resp.addCookie(cookie1);

    }
}
