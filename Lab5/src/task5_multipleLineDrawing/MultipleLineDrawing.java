/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task5_multipleLineDrawing;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
class Point{
    public int x;
    public int y;
}
public class MultipleLineDrawing extends Applet implements MouseListener,MouseMotionListener{

  int status=0,counter=0,i;
      int x_initial,y_initial,xEnd,yEnd;
      Point[] pInitial = new Point[20];
      Point[] pFinal = new Point[20];
     
    public void init() {
        
       addMouseListener(this);
       addMouseMotionListener(this);
       for (i=0;i <20;i++){
        pInitial[i] = new Point();
        pFinal[i] = new Point();
            }
       
    }  
    
   public void mousePressed(MouseEvent e)
  {
      pInitial[counter].x=pFinal[counter].x=x_initial=xEnd=e.getX();
      pInitial[counter].y=pFinal[counter].y=y_initial=yEnd=e.getY();
      status =0;
      showStatus("x="+Integer.toString(x_initial)+","+"y="+Integer.toString(y_initial));
      repaint();
  }
  public void mouseReleased(MouseEvent e)
  {
      pFinal[counter].x=xEnd=e.getX();
      pFinal[counter].y=yEnd=e.getY();
      counter +=1;
      status =1;
    showStatus("x="+Integer.toString(xEnd)+","+"y="+Integer.toString(yEnd));
    repaint();
  }  
  public void mouseClicked(MouseEvent e){}// we don't want it now  
  public void mouseEntered(MouseEvent e){}  
  public void mouseExited(MouseEvent e){}
        @Override
    public void paint(Graphics g){

   
        g.setColor(Color.black);
        //g.drawLine(x_initial,y_initial , xEnd, yEnd);
        for (i=0; i<=counter ;i++){
          g.drawLine(pInitial[i].x, pInitial[i].y, pFinal[i].x, pFinal[i].y);
      }
    
    }

    @Override
    public void mouseDragged(MouseEvent e) {
         status = 0;
         pFinal[counter].x=xEnd= e.getX(); 
         pFinal[counter].y=yEnd= e.getY(); 
         showStatus("x="+Integer.toString(xEnd)+","+"y="+Integer.toString(yEnd));
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
