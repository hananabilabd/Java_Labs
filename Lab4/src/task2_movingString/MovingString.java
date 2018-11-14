
package task2_movingString;
import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;
import task1_dateTimeApplet.DateTime;

public class MovingString extends Applet implements Runnable{

    Thread myThread;
    int x=0,temp,z=-80,flag=0;
    public void init() {
        
        myThread = new Thread(this);
        myThread.start();
    }
     @Override
    public void paint(Graphics g) {
         //Date d = new Date();
        x+=18;
        if (x> getWidth()-80 && z <5 ){
            //g.drawString("lolo", 50, 70);
            
            //temp =x-getWidth()-80;
            z+=18;
            g.drawString("Hannon Nabil", z, 50);
        }
        
        
       if (x> getWidth()){x=0;z=-80;}
         g.drawString("Hannon Nabil", x, 50);
         flag =1;
       
    }
    @Override
    public void run(){
        while(true){
            repaint();
            try{
            Thread.sleep(300);}
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
