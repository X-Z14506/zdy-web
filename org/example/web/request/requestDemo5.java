package org.example.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-03
 * Time:17:44
 */
@WebServlet("/requestDemo5")
public class requestDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求参数

        //根据参数名称获取参数值
        String username = request.getParameter("username");
        /*System.out.println("post");
        System.out.println("username");*/

        //根据参数名称获取参数值的数组
        String[] hobbies = request.getParameterValues("username");
       /* for (String hobby: hobbies) {
            System.out.println(hobby);
        }*/

        //获取所有请求的参数名称
         Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("========================");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get获取请求参数

        //根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println("username");

        //结论：request.getParameter()方法对post和get都适用，消除了他们之间的差别
    }
}
