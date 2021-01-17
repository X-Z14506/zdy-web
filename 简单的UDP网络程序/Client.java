public class Client {
    public static void main(String[] args) throws IOException {
        new Client().start();
    }

    //定义发送数据报的目的地
    public static final int DEST_PORT = 30000;
    public static final String DEST_IP = "127.0.0.1";
    //每个数据报最大为4k
    private static final int DATA_LEN = 4096;
    //接受网络数据的字节数组
    byte[] inbuff= new byte[DATA_LEN];
    //以指定字节数组创建准备接收数据的DatagramPacket对象
    private DatagramPacket packet_in = new DatagramPacket(inbuff,0,inbuff.length);
    //定义一个用于发型的DatagramPacket对象
    private DatagramPacket packet_out = null;

    public void start() throws IOException {
        try(DatagramSocket socket = new DatagramSocket()) {
            //初始化发送用的DatagramSocket
            InetAddress ip = InetAddress.getByName(DEST_IP);
            packet_out = new DatagramPacket(new byte[0],0,ip,DEST_PORT);
            //创建键盘输入流
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入数据:");
            //不断读取键盘输入
            String key = null;
            //键盘输入字符对应的byte数组
            byte[] keyBuff = null;
            while (sc.hasNext()) {
                key=sc.nextLine();
                if ("exit".equals(key)) {
                    break;
                }
                //呼入的字符串变成字节数组
                keyBuff = key.getBytes();
                //设置发送用的DatagramPacket里的字节数据
                packet_out.setData(keyBuff);
                //发送数据包
                socket.send(packet_out);
                //读取Socket中的数据，读到的数据放在inPacket所封装的字节数组里
                socket.receive(packet_in);
                System.out.println(new String(inbuff,0,packet_in.getLength()));
                System.out.print("请输入数据:");

            }
            System.out.println("====客户端退出====");
        }
    }
}
