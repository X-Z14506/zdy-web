package org.example.web.checkCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-05
 * Time:9:28
 */
@WebServlet("/checkCodeDemo1")
public class checkCodeDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 300;
        int height = 150;

        //1.创建一对象，在内存中图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2.美化图片

        //2.1填充背景色、
        Graphics g =image.getGraphics();//画笔对象
        g.setColor(Color.pink);//设置画笔颜色
        g.fillRect(0,0,width,height);//

        //2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random random = new Random();
        //随机生成4个验证码
        for (int i = 1;i <= 4;i++) {
            int index = random.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);

            //2.3写验证码
            g.drawString(ch+"",width/5*i,height/2);

        }
//        int index = random.nextInt(str.length());
//        //获取字符
//        char ch = str.charAt(index);
//
//        //2.3写验证码
//        g.drawString(ch+"",20,25);

        //2.4画干扰线
        g.setColor(Color.green);
        //随机生成坐标点
        for (int i = 0; i < 10;i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }


        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}