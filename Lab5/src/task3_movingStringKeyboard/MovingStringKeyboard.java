/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3_movingStringKeyboard;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingStringKeyboard extends Applet implements KeyListener{
    Thread th;
    int x =40 ,y=40;
    public void init() {
        //th = new Thread(new myThread());
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g){
        g.drawString("Thanks God", x, y);
    }

    @Override
    public void keyTyped(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
           throw new UnsupportedOperationException("Not supported yet.");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
        int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
        x -= 10;
    }

    if (key == KeyEvent.VK_RIGHT) {
        x += 10;
    }

    if (key == KeyEvent.VK_UP) {
        y -= 10;
    }

    if (key == KeyEvent.VK_DOWN) {
        y += 10;
    }
    if (x< 0){x=getWidth();}
    if (x > getWidth()){x=0;}
    if (y< 0){y=getHeight();}
    if (y > getHeight()){y=0;}
    repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
    class myThread implements Runnable{

        @Override
        public void run() {
            while(true){
                        repaint();
                        try{
                            Thread.sleep(100);
                           }
                        catch(Exception e){
                            e.printStackTrace();
                            }
                          }
        }
    }*/
}
