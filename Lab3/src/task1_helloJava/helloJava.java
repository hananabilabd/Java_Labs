/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1_helloJava;

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author Hanna Nabil
 */
public class helloJava extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
     @Override
    public void paint(Graphics g) {
        g.drawString("Hannooooon", 50, 100);
        //To change body of generated methods, choose Tools | Templates.
    }

    // TODO overwrite start(), stop() and destroy() methods
}
