package com.company.obj;

import javax.swing.*;
import java.awt.*;


public class Display extends JFrame {
    public static void main (String[]args) {
        Display display = new Display();
        Ship t = new Ship();
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(600, 600);
        Color c = new Color(0, 0,0);
        display.setVisible(true);
        display.setTitle("Asteroids");
        display.add(t);
        t.setBackground(c);
}
}
