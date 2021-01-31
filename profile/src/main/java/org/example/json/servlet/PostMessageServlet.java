package org.example.json.servlet;

import com.sun.xml.internal.ws.client.dispatch.PacketDispatch;
import org.example.util.DBUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-13
 * Time:18:05
 */

@WebServlet("/post-message.api")
public class PostMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String who = req.getParameter("who");
        String what = req.getParameter("what");
        //TODO:没有做任何错误处理，没有填写信息就提交，就会报500

        insertIntoMessage(who,what);

        //执行跳转
        resp.sendRedirect("message-post.html");

    }

    private void insertIntoMessage(String who,String what) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
        //保存当前时间
        Date now = new Date();
        String nowstr = dateFormat.format(now);
        System.out.println(nowstr);

        try(Connection connection = DBUtility.getConnection()) {
            String sql = "INSERT INTO messages(who, `when`,what) VALUES(?,?,?)";
            try (PreparedStatement s = connection.prepareStatement(sql)){
                s.setString(1,who);
                s.setString(2,nowstr);
                s.setString(3,what);

                s.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
