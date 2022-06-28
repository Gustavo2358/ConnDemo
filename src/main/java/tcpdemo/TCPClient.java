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

        writer.writeBytes("JOIN");
        String joinResponse = reader.readLine();
        System.out.println("resposta do servidor" + joinResponse);
        if(joinResponse.equals("OK"));
            System.out.println("Conexão estabelecida");

        String texto;
        while(true) {
            System.out.println("Digite uma palavra: ");
            texto = inFromUser.readLine();
            if(texto.equals("quit")) break;
            writer.writeBytes(texto + "\n");
            String reponse = reader.readLine();
            System.out.println("Do servidor: " + reponse);
        }
        s.close();
    }
}
