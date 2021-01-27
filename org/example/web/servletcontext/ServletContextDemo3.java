package org.example.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-05
 * Time:10:45
 */
@WebServlet( "/ServletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         /*
             ServletContext功能
             1.获取MIME类型：

             2.域对象：共享数据
             3.获取文件的真实（服务器）路径
         */
        //通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //获取文件的服务路径
        String realPathB = context.getRealPath("b/txt");//web目录下的资源访问
        System.out.println(realPathB);
        String realPathC = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(realPathC);
        String realPathA = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(realPathA);
//        File file =new File(realPath);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
