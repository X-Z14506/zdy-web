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
 * Time:15:19
 */


/**
 * cookie快速入门
 */

@WebServlet("/cookieDemo3")
public class cookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.创建多个cookie对象
        Cookie c = new Cookie("msg","hello");
        Cookie a = new Cookie("name","zhangsan");
        //2.发送cookie
        response.addCookie(c);
        response.addCookie(a);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
