package remove_array_element;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class FrameDemo {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createGUI() {
        //Create and set up the window.
    	//JFrame frame = Global.frame;
        Global.frame.setDefaultCloseOperation(Global.frame.EXIT_ON_CLOSE);
 
        
        Global.emptyLabel.setPreferredSize(new Dimension(300, 200));
        Global.frame.getContentPane().add(Global.emptyLabel, BorderLayout.CENTER);
        
        //Display the window.
        Global.g2d.drawString("test", 10, 10);
        Global.frame.pack();
        Global.frame.setVisible(true);
        
       // Global.g.fillOval(50, 50, 20, 20);
    }
    public static void joonista(){
        
 
        //Display the window.
        Global.g.fillOval(50, 50, 20, 20);

    }
 
    public static void start(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
               // joonista();
            }
        });
    }
}