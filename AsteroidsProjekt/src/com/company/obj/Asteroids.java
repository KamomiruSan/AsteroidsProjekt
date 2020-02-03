package com.company.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;

public class Asteroids extends JPanel implements ActionListener {
    Timer t = new Timer(5,this);
    double x = 0, y = 0 , velX = 2, velY = 2;


    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x , y , 40, 40);
        g2.fill(circle);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        if( x < 0 || x > 580){
            velX = -velX;
        }
        if (y < 0 ||y > 580){
            velY = - velY;
        }
        x += velX;
        y += velY;
        repaint();

    }
}
