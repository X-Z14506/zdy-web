public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        Scanner sc = new Scanner(System.in);
        try(DatagramSocket socket = new DatagramSocket()){
            while (true) {
                System.out.println("随便输入什么然后回车");
                sc.nextLine();

                byte[] sendBuffer = {9,5,2,7};
                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuffer,0,sendBuffer.length,
                        InetAddress.getByName("127.0.0.1"),
                        9939);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
