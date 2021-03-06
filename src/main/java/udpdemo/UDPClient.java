package udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress ipAddress = InetAddress.getByName("127.0.0.1");

        byte[] sendData = new byte[1024];
        sendData = "sou um cliente".getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 9876);

        clientSocket.send(sendPacket);
        System.out.println("Mensagem enviada para o servidor");


        byte[] recBuffer = new byte[1024];
        DatagramPacket recPkt = new DatagramPacket(recBuffer, recBuffer.length);

        clientSocket.receive(recPkt);
        String informacao = new String(recPkt.getData(), recPkt.getOffset(), recPkt.getLength());
        System.out.println("Mensagem recebida do Servidor");
        System.out.println(informacao);

        clientSocket.close();

    }
}
