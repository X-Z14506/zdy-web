/*
简单的udp网络程序
实现一个简单的服务端接受客户端输入的信息然后在服务端显示
 */
public class Server {
    public static void main(String[] args) throws IOException {
        new Server().start();
    }
    //定义udp端口号
    public static final int PORT = 30000;
    //每个数据报最大为4k
    private static final int DATA_LEN = 4096;
    //接受网络数据的字节数组
    byte[] buff_in = new byte[DATA_LEN];
    //以指定字节数组创建准备接收数据的DatagramPacket对象
    private DatagramPacket packet_in = new DatagramPacket(buff_in,0,buff_in.length);
    //定义一个用于发型的DatagramPacket对象
    private DatagramPacket packet_out;

    public void start() throws IOException {
        try(DatagramSocket socket = new DatagramSocket(PORT)){
            String word = null; //客户端输入的英文单词
            SocketAddress address = null; //获取客户端对象，通过该对象将数据写给对方，否则没有目的地
            byte[] receiveData = null;//返回客户端的数据
            System.out.println("服务端启动了...");
            while (true) {
                //读取socket中的数据，然后将数据封装到packet_in中
                socket.receive(packet_in);
                //获取客户端输入的数据
                buff_in=packet_in.getData();
                //将byte数组转换为字符串，需要去掉后面的空格
                word=new String(buff_in,0,buff_in.length).trim();
                System.out.println("客户端输入的是："+word);
                address = packet_in.getSocketAddress();
                //检查退出条件
                if ("down".equals(word)) {
                    receiveData="服务器关闭了，请重试".getBytes();
                    packet_out=new DatagramPacket(receiveData,receiveData.length,address);
                    socket.send(packet_out);
                    break;
                }else {
                    //构架服务端发送给客户端的数据
                    receiveData=("你输入的英文单词是："+word).getBytes();
                    //构建packet_out发送数据
                    packet_out=new DatagramPacket(receiveData,receiveData.length,address);
                    socket.send(packet_out);
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("========服务端关闭========");
        }
    }
}
