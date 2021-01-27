package org.example.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-03
 * Time:17:06
 */
@WebServlet("/requestDemo4")
public class requestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求体--请求参数

        //1.获取字符流
        BufferedReader br = request.getReader();
        //2.读取数据
        String line = null;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
