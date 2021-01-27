package org.example.web.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-05
 * Time:13:39
 */
@WebServlet("/downLoadServlet")
public class downLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/image/"+filename);
        //2.2用字节流关联
        FileInputStream f = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);

        //3.2设置响应头打开方式，content-disposition
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream s =response.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len = 0;
        while ((len = f.read(buff)) != -1) {
            s.write(buff,0,len);
        }
        f.close();;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
