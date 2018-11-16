
package chatRoom;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class ChatServer {
    ServerSocket serverSocket;
 
    public ChatServer() 
        {
         try{
        
        serverSocket= new ServerSocket(5005);
        while(true)
        {
        Socket s = serverSocket.accept();
        new ChatHandler(s);
        }
        }
        catch(IOException ex)
        {
        ex.printStackTrace();
        }
        }
    
   
    
    public static void main(String[] args)
{
    new ChatServer();
}
    
}

class ChatHandler extends Thread
{
    DataInputStream dis;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector=new Vector<ChatHandler>();
    public ChatHandler(Socket cs) throws IOException
    {
    dis = new DataInputStream(cs.getInputStream());
    ps= new PrintStream(cs.getOutputStream());
    clientsVector.add(this);
    start();
    
}
        public void run()
    {
    while(true)
    {
        try{
    String str= dis.readLine();
    sendMessageToAll(str);}
        catch(Exception e){
            e.printStackTrace();
            clientsVector.remove(this);
        }
    }
    }
    void sendMessageToAll(String msg)
    {
    for(ChatHandler ch: clientsVector)
    {
    ch.ps.println(msg);
    }
    }
    
}