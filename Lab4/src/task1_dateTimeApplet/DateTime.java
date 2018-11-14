/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1_dateTimeApplet;
import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Date;

public class DateTime extends Applet implements Runnable{

    Thread myThread;
    public void init() {
        DateTime obj = new DateTime();
        myThread = new Thread(this);
        myThread.start();
    }
     @Override
    public void paint(Graphics g) {
         Date d = new Date();
         g.drawString(d.toString(), 15, 50);
    }
    @Override
    public void run(){
        while(true){
            repaint();
            try{
            Thread.sleep(1000);}
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    

    // TODO overwrite start(), stop() and destroy() methods
}
