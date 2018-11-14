/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3_animationBall;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class AnimationBall extends Applet implements Runnable{
    Thread myThread;
    int x=0 , y =50;
    int quad1=1,quad2=0,quad3=0,quad4=0,flag=0;
    @Override
    public void init(){
        myThread =new Thread(this);
        myThread.start();
    }
    @Override
    public void paint(Graphics g){
       
        g.setColor(Color.yellow);
        if (quad1==1){
         if (flag==1){
            x=0;
            //y=50;
             flag=0;}
         else{
        x+=5;
        y-=2;}
        if (y<10){
            quad1=0;
            quad2=1;
        }
        }
        else if (quad2==1){
            
            x+=5;
            y+=2;
            if (x> getWidth()-40){
                quad2=0;
                quad3=1;
            }
        }
         else if (quad3==1){
            x-=5;
            y+=2;
            if (y>=getHeight()-40){
                quad3=0;
                quad4=1;
            }
        }
        else if (quad4==1){
            x-=5;
            y-=2;
           
            if (x<0  ){
                //g.drawString("hi", 24, 40);
                quad4=0;
                quad1=1;
                flag=1;
            }
        }
     
        g.fillOval(x, y, 40,40);
        
    }
    @Override
    public void run(){
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

    
}
