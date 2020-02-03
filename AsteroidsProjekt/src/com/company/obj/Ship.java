package com.company.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.security.Key;

public class Ship extends JPanel implements ActionListener, KeyListener {


    Timer tm = new Timer(5, this);
    int x = 0, y = 0, velX = 0, velY = 0;

    public Ship() {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 10, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x < 0){
            velX = 0;
            x = 580 ;
        }
        if(x > 580){
            velX = 0;
            x = 0;
        }
        if(y < 0){
            velY = 0;
            y = 580;
        }
        if(y > 580){
            velY = 0;
            y = 0;
        }
        x = x + velX;
        y = y + velY;
        repaint();
    }


    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) { //pohyb
            velX = -1;
            velY = 0;
        }
        if (c == KeyEvent.VK_UP) {
            velX = 0;
            velY = -1;
        }
        if (c == KeyEvent.VK_RIGHT) {
            velX = 1;
            velY = 0;
        }
        if (c == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = 1;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

