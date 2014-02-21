package remove_array_element;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
 
/*
 * LabelDemo.java needs one other file:
 *   images/middle.gif
 */
public class LabelDemo extends JPanel {
    public LabelDemo(String x) throws IOException {
        super(new GridLayout(3,1));  //3 rows, 1 column
        JLabel label1, label2, label3, label4;
 
       // ImageIcon icon = createImageIcon("http://images.wikia.com/fantendo/images/6/6e/Small-mario.png","a pretty but meaningless splat");
        Toolkit tk = Toolkit.getDefaultToolkit();
    //	Image image = tk.getImage ("D://temp/test.png");
        Image image = tk.getImage ("D://temp/riita1.png");
        ImageIcon icon = new ImageIcon(image);
        
        int imageheight=image.getHeight(null);
        int imagewidth=image.getWidth(null);
        Image img = icon.getImage();  
        Image newimg = img.getScaledInstance((imagewidth/10),(imageheight/10),   java.awt.Image.SCALE_SMOOTH);  
        icon = new ImageIcon(newimg);  
      /*  
        Image image2=tk.getImage("D://temp/riita1.png");
        imageheight=image2.getHeight(null);
        imagewidth=image.getWidth(null);
       */ 
        
        Toolkit tk1 = Toolkit.getDefaultToolkit();
        Image image1 = tk1.getImage ("D://temp/test.png");
        BufferedImage pildike;
	
			pildike = ImageIO.read(new File("D://temp/test.png"));
			//pildike.getScaledInstance((imagewidth/10),(imageheight/10),   java.awt.Image.SCALE_SMOOTH);
	ImageIcon jura=new ImageIcon(pildike);
	Image jurakas= jura.getImage();
	 imageheight=jurakas.getHeight(null);
     imagewidth=jurakas.getWidth(null);
			jurakas=jurakas.getScaledInstance((imagewidth/2),(imageheight/2),   java.awt.Image.SCALE_SMOOTH);
        ImageIcon ikoon = new ImageIcon(image1);
        imageheight=image1.getHeight(null);
        imagewidth=image1.getWidth(null);
        Image img1 = ikoon.getImage();  
        Image newimg1 = img1.getScaledInstance((imagewidth/2),(imageheight/2),   java.awt.Image.SCALE_SMOOTH);  
        ikoon=new ImageIcon(newimg1);
        
        //Create the first label.
        label1 = new JLabel("Image and Text",icon,
                            JLabel.CENTER);
        //Set the position of its text, relative to its icon:
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);
 
        //Create the other labels.
        label2 = new JLabel("Text-Only Label");
        
        Graphics g=pildike.getGraphics();
        g.drawLine(100, 100, 100, 100);
        ImageIcon ikoonike = new ImageIcon(jurakas);
        label3 = new JLabel(ikoonike);
       // label3 = new JLabel(icon);
       
        label4 = new JLabel(ikoon,JLabel.RIGHT);
       
        //Create tool tips, for the heck of it.
        label1.setToolTipText("A label containing both image and text");
        label2.setToolTipText("A label containing only text");
        label3.setToolTipText("A label containing only an image");
        label4.setToolTipText("Kuvab ainult pilti");
 
        //Add the labels.
        add(label1);
        add(label2);
        add(label3);
        add(label4);
    }
 
    
    
    
    
    
    
    
    
    
    
    
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    
  /*  protected static ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = LabelDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }*/
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     * @throws IOException 
     */
    private static void createAndShowGUI() throws IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("Pele pildid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new LabelDemo("tadaa"));
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void start(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        //Turn off metal's use of bold fonts
            UIManager.put("swing.boldMetal", Boolean.FALSE);
                 
        try {
			createAndShowGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }
        });
    }
}
