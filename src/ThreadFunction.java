import java.io.*;
import java.net.*;
import java.util.Date;


public class ThreadFunction implements Runnable{
    
    private Socket socket;

    public ThreadFunction(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            System.out.println("thread created");
            while (true){
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String client_msg = reader.readLine();

                //System.out.println(client_msg);

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                writer.println(new Date().toString());
            }
        }
         catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}