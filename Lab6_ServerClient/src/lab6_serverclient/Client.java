
package lab6_serverclient;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Client {
    Socket mySocket;
    DataInputStream dis ;
    PrintStream ps;
public static void main(String[] args)
{
    new Client();
}
public Client()
{
try
    {
    mySocket= new Socket("127.0.0.1", 5005);
    dis = new DataInputStream(mySocket.getInputStream());
    ps= new PrintStream(mySocket.getOutputStream());
    ps.println("Hello Guys");
    String replyMsg= dis.readLine();
    System.out.println(replyMsg);
    }
    catch(Exception ex)
    {
    ex.printStackTrace();
    }
    try
    {
    ps.close();
    dis.close();
    mySocket.close();
    }
    catch(Exception ex)
    {
    ex.printStackTrace();
    }
}  
   
}
