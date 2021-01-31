package org.example.profile;

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
 * Date:2020-12-09
 * Time:23:57
 */

@WebServlet("/jsp")
public class HomeServlet extends HttpServlet {
    //TODO 需要修复线程安全问题
//    private static int count;  肯定可以
    private  int count;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        count++;
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String temp = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>个人名片</title>\n" +
                "    <link href=\"./css/app.css\" rel=\"stylesheet\">\n" +
                "    <style>\n" +
                "        h2.hello {\n" +
                "            color: cornflowerblue;\n" +
                "        }\n" +
                "        h2.hello:hover{\n" +
                "            color: cyan;\n" +
                "        }\n" +
                "        ul.hobby{\n" +
                "            color: blueviolet;\n" +
                "        }\n" +
                "        ul.hobby:hover {\n" +
                "            color: lawngreen;\n" +
                "        }\n" +
                "        ol.hobby{\n" +
                "            color: salmon;\n" +
                "        }\n" +
                "        ol.hobby:hover{\n" +
                "            color: red;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>访问此次数::count:</div>\n" +
                "<div>\n" +
                "    <h1 class=\"center\">个人简历</h1>\n" +
                "    <h1 class=\"center\">:name:</h1>\n" +
                "    <h5 class=\"center\">西安工程大学</h5>\n" +
                "    <h5 class=\"center\">机械电子工程</h5>\n" +
                "    <p style=\"color: blueviolet\">JAVA小白</p>\n" +
                "</div>\n" +
                "<div>\n" +
                "    <h2 class=\"hello\">我的爱好</h2>\n" +
                "    <ul class=\"hobby\">\n" +
                "        <li>打游戏</li>\n" +
                "        <li>睡觉</li>\n" +
                "        <li>打麻将</li>\n" +
                "        <li>\n" +
                "            <a href=\"https://blog.csdn.net/weixin_49786076?spm=1010.2135.3001.5113\">CSDN</a>\n" +
                "        </li>\n" +
                "    </ul>\n" +
                "</div>\n" +
                "<div>\n" +
                "    <h2 class=\"hello\">我的工作经历</h2>\n" +
                "    <ol class=\"hobby\">\n" +
                "        <li>2017-2020西安工程大学</li>\n" +
                "        <li>\n" +
                "            <a href=\"https://www.baidu.com/\">百度</a>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            <a href=\"https://news.qq.com/\">腾讯</a>\n" +
                "        </li>\n" +
                "        <li>阿里</li>\n" +
                "    </ol>\n" +
                "</div>\n" +
                "<img src=\"./image/huyan3.jpg\" alt=\"这是我的桌面背景\" width=\"500\" height=\"200\">\n" +
                "</body>\n" +
                "</html></html>";
        String content = temp.replace(":name:",name)
                             .replace(":count:",String.valueOf(count));
        writer.println(content);
    }
}
