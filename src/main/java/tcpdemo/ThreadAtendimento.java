package tcpdemo;

import java.io.*;
import java.net.Socket;
import java.util.Locale;

public class ThreadAtendimento extends Thread{

    private Socket no;

    public  ThreadAtendimento(Socket no){
        this.no = no;
    }

    public void run(){
    InputStreamReader is;
    OutputStream os;
    try {
        is = new InputStreamReader(no.getInputStream());
        BufferedReader reader = new BufferedReader(is);
        String texto = reader.readLine();
        os = no.getOutputStream();
        DataOutputStream writer = new DataOutputStream(os);
        writer.writeBytes(texto.toUpperCase(Locale.ROOT) + "\n");
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}
