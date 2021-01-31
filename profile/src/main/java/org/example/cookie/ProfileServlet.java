package org.example.cookie;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-16
 * Time:11:11
 */


@WebServlet("/session-test")
public class ProfileServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session==null) {
            System.out.println("应爱让重新登录");
            return;
        }

        String 姓名 = (String) session.getAttribute("姓名");
        int 年龄 = (Integer)session.getAttribute("年龄");
        System.out.println(姓名);
        System.out.println(年龄);
    }
}
