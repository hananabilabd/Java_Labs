/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_serverclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    ServerSocket myServerSocket;
    Socket s;
    DataInputStream dis ;
    PrintStream ps;
    public static void main(String[] args) {
        new Server();
    }
    public Server(){
        try
          {
        myServerSocket= new ServerSocket(5005);
        s = myServerSocket.accept();
        dis = new DataInputStream(s.getInputStream());//to handle what will be received
        ps= new PrintStream(s.getOutputStream());//to handle what will be send
        String msg= dis.readLine();
        System.out.println(msg);
        ps.println("From Server: Data Received");
        }
        catch(IOException ex)
        {
        ex.printStackTrace();
        }
        try
        {
        ps.close();
        dis.close();
        s.close();
        myServerSocket.close();
        }
        catch(Exception ex)
        {
        ex.printStackTrace();
        }
    }
    
}
