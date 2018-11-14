
package task4_singleLineDraw;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawSingleLine extends Applet implements MouseListener,MouseMotionListener{

   String str,str2 ;
    int status=0;
      int x_initial,y_initial,xEnd,yEnd;
    public void init() {
        str =new String();
        str2 =new String();
       addMouseListener(this);
       addMouseMotionListener(this); 
    }  
    
   public void mousePressed(MouseEvent e)
  {
      x_initial=xEnd=e.getX();
      y_initial=yEnd=e.getY();
      
      showStatus("x="+Integer.toString(x_initial)+","+"y="+Integer.toString(y_initial));
    repaint();
  }
  public void mouseReleased(MouseEvent e)
  {
      xEnd=e.getX();
      yEnd=e.getY();
  
    showStatus("x="+Integer.toString(xEnd)+","+"y="+Integer.toString(yEnd));
    repaint();
  }  
  public void mouseClicked(MouseEvent e){}// we don't want it now  
  public void mouseEntered(MouseEvent e){}  
  public void mouseExited(MouseEvent e){}
        @Override
    public void paint(Graphics g){

   
    if(status == 1)      
    {
      g.setColor(Color.red);
      g.drawLine(x_initial, y_initial, xEnd, yEnd);
    }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
         status = 1;
         xEnd= e.getX(); 
         yEnd= e.getY(); 
         showStatus("x="+Integer.toString(xEnd)+","+"y="+Integer.toString(yEnd));
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
