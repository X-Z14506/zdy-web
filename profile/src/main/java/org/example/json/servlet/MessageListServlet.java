package org.example.json.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sun.xml.internal.ws.api.model.MEP;
import org.example.json.model.Message;
import org.example.util.DBUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-11
 * Time:18:48
 */

@WebServlet("/message-list.json")
public class MessageListServlet extends HttpServlet {
  /*  //数据库连接
    private static DataSource dataSource;
    //静态代码块中初始化静态属性
    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        mysqlDataSource.setServerName("localhost");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("1450618603");
        mysqlDataSource.setDatabaseName("db2020");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf-8");
        dataSource = mysqlDataSource;
    }
*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messages = getMessageList();

        String jsonMessage = buildJSONByJackson(messages);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(jsonMessage);


        //System.out.println(jsonMessage);


    }

    private String buildJSONByJackson(List<Message> messages) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(messages);
        } catch (JsonProcessingException e) {
            e.printStackTrace();  //不要吞异常
            return "";
        }
    }

    private List<Message> getMessageList() {
        List<Message> messageList = new ArrayList<>();
        try (Connection connection = DBUtility.getConnection()){
            String sql = "SELECT id,who,what,`when` FROM messages ORDER BY id DESC";
            try (PreparedStatement s = connection.prepareStatement(sql)){
                try (ResultSet rs = s.executeQuery()){
                    while (rs.next()) {
                        Message message = new Message();
                        message.id  = rs.getInt("id");
                        message.who = rs.getString("who");
                        message.when = rs.getString("when");
                        message.what = rs.getString("what");


                        messageList.add(message);
                    }
                    return messageList;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

/*

    private String buildJSON(List<Message> messages) {
        StringBuilder sb = new StringBuilder("[");
        for (Message message : messages){
            sb.append("{\n");
            sb.append("    \"id:");
            sb.append(message.id);
            sb.append(",\n");
            sb.append("     \"who\":");
            sb.append("\"");
            sb.append(message.who);
            sb.append("\"");
            sb.append("},\n");
        }

        sb.delete(sb.length()-1,sb.length());
        sb.append("]");
        return sb.toString();
    }
*/

   /* private List<Message> getMessageList() {
        List<Message> messages = new ArrayList<>();

        Message m1 = new Message();
        m1.id = 1;
        m1.who="达摩老祖";
        messages.add(m1);
        Message m2 = new Message();
        m2.id = 2;
        m2.who="达摩老祖2";
        messages.add(m2);
        Message m3 = new Message();
        m3.id = 3;
        m3.who="达摩老祖3";
        messages.add(m3);
        Message m4 = new Message();
        m4.id = 4;
        m4.who="达摩老祖4";
        messages.add(m4);

        return messages;
    }*/
}
