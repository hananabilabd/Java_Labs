/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4_lampRepaint;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

/**
 *
 * @author Hanna Nabil
 */
public class Lamp extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    @Override
    public void paint(Graphics g) {
       //Color c=new Color(200,100,150);
       g.setColor(Color.YELLOW);
       g.fillOval(100, 20, 100, 50);
       g.setColor(Color.black);
       g.drawOval(100, 20, 100, 50);
       
       
       g.setColor(Color.black);
       g.drawLine(100, 45, 80, 100);
       g.drawLine(200, 45, 220, 100);
       //g.fillArc(80, 60, 140, 80, -180, 180);
       g.fillOval(150, 40, 5,5);//the point
       g.drawArc(80, 60, 140, 80, -180, 180);
       g.setColor(Color.yellow);
       g.fillOval(138, 80, 30,55);
       
       g.fillOval(90, 80, 30,30);
       g.fillOval(180, 80, 30,30);
       g.setColor(Color.black);
       g.drawRect(95, 190, 120, 15);
       g.drawLine(140, 140, 130, 190);
       g.drawLine(160, 140, 170, 190);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
