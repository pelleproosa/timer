package remove_array_element;




import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class frame_tekst {

  public static void start(String[] args) {
    JFrame jf = new JFrame("Pele URL Ping");
    Container cp = jf.getContentPane();
    MyCanvas tl = new MyCanvas();
    cp.add(tl);
    jf.setSize(300, 400);
    jf.setVisible(true);
  }
}


class MyCanvas extends JComponent {

 @Override
  public void paintComponent(Graphics g) {
      if(g instanceof Graphics2D)
      { 
    	while(true){
    		teinetaimer.alusta(null);
    	  
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawString("OLEK:",20,25); 
 //g2.drawString("Connection Failure:", 70, 20);
 if (Global.pingtagastus.equals("OK")){
	 if(g2.getColor()==Color.black){
		 g2.setColor(Color.GREEN);
	 }else{
		 g2.setColor(Color.black);
	 }
	 g2.fillOval(100, 10, 20, 20);
 }else{
	 g2.setColor(Color.red);
	 g2.fillOval(100, 10, 10, 10);
	 g2.drawString(Global.pingtagastus, 20, 25);
 }

    	}  
 //g2.setColor(Color.black);
// g2.fillOval(100, 10, 20, 20);
//g2.setColor(Color.GREEN);
 //g2.fillOval(60, 10, 20, 20);
      }
   
      
   }
}