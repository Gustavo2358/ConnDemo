package tcpdemo;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("127.0.0.1", 9000);
        OutputStream os = s.getOutputStream();
        DataOutputStream writer = new DataOutputStream(os);

        InputStreamReader is = new InputStreamReader(s.getInputStream());
        BufferedReader reader = new BufferedReader(is);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String texto = inFromUser.readLine();

        writer.writeBytes(texto + "\n");

        String reponse = reader.readLine();
        System.out.println("Do servidor: " + reponse);

        s.close();
    }
}
