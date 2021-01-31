package org.example.json.servlet;

import org.example.util.DBUtility;
import sun.awt.geom.AreaOp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-13
 * Time:20:25
 */

@MultipartConfig
@WebServlet("/post-file.api")
public class PostFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

   /*     Part imagePart = req.getPart("image");
        InputStream inputStream = imagePart.getInputStream();
        try(Connection c = DBUtility.getConnection()){
            String sql = "INSERT INTO images(content) VALUES(?)";
            try (PreparedStatement s = c.prepareStatement(sql)){
                s.setBinaryStream(1,inputStream);//这句话注意
            }
        }catch (SQLException e) {
            throw new ServletException(e);
        }
*/

//        Part usernamePart = req.getPart("username");
//        InputStream usernameIS = usernamePart.getInputStream();
//        Scanner s = new Scanner(usernameIS,"utf-8");
//        String next = s.next();
//        System.out.println(next);


       /* Reader usernameReader = new InputStreamReader(usernameIS,"UTF-8");
        char[] buf = new char[(int)usernamePart.getSize()];
        int n = usernameReader.read(buf);
        String s = new String(buf,0,n);
        System.out.println(s);*/

//        Part passwordPart = req.getPart("password");

        //上传文件至目录："F:\\java\\output.txt"
        Part imagePart = req.getPart("image");
        InputStream inputStream = imagePart.getInputStream();
        OutputStream outputStream = new FileOutputStream("F:\\java\\Maven\\profile\\target\\profile-1.0-SNAPSHOT\\huYan.jpg");

        byte[] buffer = new byte[1024];
        while (true) {
            int n = inputStream.read(buffer);
            if (n == -1) {
                break;
            }
            //buffer[0,n)
             outputStream.write(buffer,0,n);
        }

        outputStream.close();


        /*System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        System.out.println(req.getParameter("image"));*/
    }
}
