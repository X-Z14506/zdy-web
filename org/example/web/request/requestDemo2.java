package org.example.web.request;

import sun.util.resources.cldr.en.CalendarData_en_UM;

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
 * Time:16:17
 */
@WebServlet("/requestDemo2")
public class requestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据
        //1.获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();

        //2.遍历
        while (headerNames.hasMoreElements()) {
            String name =headerNames.nextElement();

            //根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name+"---"+value);
        }

        //演示获取请求头数据：user-agent
        String agent = request.getHeader("user-agent");
        System.out.println(agent);

        //判断agent的浏览器版本
        if (agent.contains("Chrome")) {
            //谷歌
            System.out.println("谷歌来了...");
        }else if (agent.contains("Firefox")) {
            //火狐
            System.out.println("火狐来了...");
        }


    }
}
