package org.example.ajaxTest;

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
 * Date:2020-12-11
 * Time:12:47
 */

////统计访问次数++，带着js；定期（每5s，获取最新的请求次数并更新

@WebServlet("/ajaxTest")
public class IndexServlet extends HttpServlet {
    static int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");


        PrintWriter writer = resp.getWriter();
        String temp = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>首页</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p id=\"content\">::count::</p>\n" +
                "<script src=\"./jquery-3.5.0.min.js\"></script>\n" +
                "<script src=\"./js/ajaxTest.js\"></script>\n" +
                "</body>\n" +
                "</html>";
        String content = temp.replace("::count::",String.valueOf(count));
        writer.println(content);
    }
}
