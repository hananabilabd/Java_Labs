/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3_fontList;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

/**
 *
 * @author Hanna Nabil
 */
public class FontList extends Applet {

     @Override
    public void paint(Graphics g) {
         String[] s = Toolkit.getDefaultToolkit().getFontList();
         int y =10;
        for (int i =0;i<s.length;i++){
            //String z=Integer.toString(s.length);
            //g.drawString(z, 155, y);
            
            y +=20;
            Font f = new Font(s[i],2,30);
            g.setFont(f);
            g.drawString(s[i], 15, y);
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    // TODO overwrite start(), stop() and destroy() methods
}
