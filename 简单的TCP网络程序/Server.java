
/*
1.socket：
举个例子，假如两个人A,B要通信，他们使用一种信件交流的方法，并且规定好了信箱，
一方把信件放在信箱里面，另一方就可以去看socket简单来说就是连接两个程序的信箱

2.127.0.0.1
127.0.0.1是回送地址，指本地机，一般用来测试使用。回送地址是本机回送地址（Loopback Address），
即主机IP堆栈内部的IP地址，主要用于网络软件测试以及本地机进程间通信，无论什么程序，一旦使用回送地址发送数据，协议软件立即返回，不进行任何网络传输
 */

    /*
     客户端是先写后读（先发出请求，后得到回应）
    服务器是先读后写（先收到请求，后发出回应）
     */
     
public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建绑定到指定端口的服务器套接字
        ServerSocket tcpServerSocket=new ServerSocket(1234);

        Scanner sc=new Scanner(System.in);
        while(true){
            //2.服务器和客户端的链接，如果链接不上一直在这里停留
            Socket cilentSocket=tcpServerSocket.accept();
            InetAddress cilentAddress= ((Socket) cilentSocket).getInetAddress();
            System.out.printf("有客户端 %s ：%d 连接上来\n",
                    ((InetAddress) cilentAddress).getHostAddress(),  //客户端的IP
                    cilentSocket.getPort()           //客户端的端口号
            );

            //获取输入字节流
            InputStream is=cilentSocket.getInputStream();
            //字节流转换为字符流
            InputStreamReader isReader=new InputStreamReader(is,"UTF-8");
            //字符流转换缓冲字符流（主要是为了用它的 readLine() 方法）
            BufferedReader reader=new BufferedReader(isReader);

            //获取输出字节流
            OutputStream os=cilentSocket.getOutputStream();  //从客户端得到的输出字节流
            //将字节流转换为字符流（主要是为了用它的 println() 方法）
            PrintStream out=new PrintStream(os);

            String line;
            while((line=reader.readLine())!=null){  //从客户端读发来的消息
                System.out.println("客户端："+line);
                System.out.print("服务器：");
                String response=sc.nextLine();
                out.println(response);   //输出到客户端
            }
        }
    }
}
