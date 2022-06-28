package tcpdemo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class TCPServerConcorrente {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9000);
        while(true){
            Socket no = serverSocket.accept();
            System.out.println("Conexão de " + no.getRemoteSocketAddress());
            connection(no);

            ThreadAtendimento thread = new ThreadAtendimento(no);
            thread.start();
        }

    }
    private static void connection(Socket no) throws Exception{
        InputStreamReader is = new InputStreamReader(no.getInputStream());
        BufferedReader reader = new BufferedReader(is);
        String texto = reader.readLine();
        System.out.println(texto);
        OutputStream os = no.getOutputStream();
        DataOutputStream writer = new DataOutputStream(os);
        if(texto.equals("JOIN"))
            writer.writeBytes("OK");
    }
}
