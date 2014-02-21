package remove_array_element;

//File   : layouts/borderLayout/BorderTest.java
//Purpose: Demo use of BorderLayout.
//Author : Fred Swartz - 2006-09-24 - Placed in public domain.

import java.awt.*;
import javax.swing.*;

///////////////////////////////////////////////// class BorderTest
class Start extends JFrame {

 //======================================================= main
 public static void start(String[] args) {
     JFrame window = new Start();
     window.setVisible(true);
 }

 //================================================ constructor
 Start() {
     //... Create components (but without listeners)
     JButton north  = new JButton("North");
     JButton east   = new JButton("East");
     JButton south  = new JButton("South");
     JButton west   = new JButton("West");
     JButton center = new JButton("Center");

     //... Create content pane, set layout, add components
     JPanel content = new JPanel();
     content.setLayout(new BorderLayout());

     content.add(north , BorderLayout.NORTH);
     content.add(east  , BorderLayout.EAST);
     content.add(south , BorderLayout.SOUTH);
     content.add(west  , BorderLayout.WEST);
     content.add(center, BorderLayout.CENTER);

     //... Set window characteristics.
     setContentPane(content);
     setTitle("BorderTest");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     pack();
 }
}