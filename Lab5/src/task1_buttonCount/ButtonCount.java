
package task1_buttonCount;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
public class ButtonCount extends Applet implements ActionListener{
    int x,y;
    Button b ,b2;
      @Override
      public void actionPerformed(ActionEvent e) {
          if (e.getSource() == b) {
              
               x++;
            repaint();
          }
          else {
              if (x<=0){
              x=0;}
              else {
                  x--;
              }
              repaint();
          } 
        }
    @Override
    public void init() {
        b= new Button("Increment");
        b.addActionListener(this);// b.addActionListener(MyButtonListenerIncrement );
        add(b);
        b2= new Button("Decrement");
        b2.addActionListener(this);// b.addActionListener(MyButtonListenerDecrement );
        add(b2);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Click count is ="+x, 20, 50);
    }
    class MyButtonListenerIncrement implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             x++;
            repaint();
        }
        
    }
     class MyButtonListenerDecrement implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             x--;
            repaint();
        }
        
    }

    
}
