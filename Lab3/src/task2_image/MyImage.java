/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2_image;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Hanna Nabil
 */
public class MyImage extends Applet {

    Image pic;
    
    @Override
    public void init() {  
    pic = getImage(getCodeBase(),"image.jpg");
     }  
    @Override
    public void paint(Graphics g) {
        int w=pic.getHeight(this);
        int h =pic.getWidth(this);
        //g.drawImage(pic, 0, 0, w, h, this);
        g.drawImage(pic,0,0,getWidth(),getHeight(), this);
        //To change body of generated methods, choose Tools | Templates.
    }

    // TODO overwrite start(), stop() and destroy() methods
}
