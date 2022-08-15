import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
       public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
       private Socket socket;
       private BufferedReader bufferedReader;
       private BufferedWriter bufferedWriter;
       private String Clientusername;

       public ClientHandler(Socket socket) {
           try{
               this.socket = socket;
               this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
               this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
               this.clientusername = bufferedReader.readLine();
               clientHandlers.add(this);
               broadcastMessage("SERVER :" + clientusername)
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }
    @Override
    public void run() {

    }
}