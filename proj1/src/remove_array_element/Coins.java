package remove_array_element;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Coins extends JPanel implements ActionListener {
   private static final String COIN_URL_PATH = "http://cdn.dailyclipart.net/wp-content/uploads/medium/clipart0273.jpg";
//   private static final String COIN_URL_PATH2 = "http://content.scholastic.com/content/media/products/71/0439510171_rgb15_xlg.jpg";
//   private static final String COIN_URL_PATH3 = "http://uscoinstoday.com/images/e/130580876887_0.jpg";
   private static final int PAN_WIDTH = 900;
   private static final int PAN_HT = 700;
   protected static final int TRANSPARENT = new Color(255, 255, 255, 0).getRGB();
   private Timer t;
   private BufferedImage coinImage;
   private ImageIcon coinIcon;
   private Random random = new Random();

   public Coins() {
      setLayout(null);
      try {
         coinImage = ImageIO.read(new URL(COIN_URL_PATH));
         double scaleFactor = 0.35;
         BufferedImage destImg = new BufferedImage((int)(coinImage.getWidth() * scaleFactor),
               (int) (coinImage.getHeight() * scaleFactor), BufferedImage.TYPE_INT_ARGB);
         
         AffineTransform at = AffineTransform.getScaleInstance(scaleFactor, scaleFactor);
         AffineTransformOp ato = new AffineTransformOp(at,
               AffineTransformOp.TYPE_BICUBIC);
         ato.filter(coinImage, destImg);

         ImageFilter whiteToTranspFilter = new RGBImageFilter() {

            @Override
            public int filterRGB(int x, int y, int rgb) {
               Color color = new Color(rgb);
               int colorSum = color.getBlue() + color.getRed() + color.getGreen();
               int maxColorSum = 600;
               if (colorSum > maxColorSum ) {
                  return TRANSPARENT;
               }
               return rgb;
            }
         };
         ImageProducer ip = new FilteredImageSource(destImg.getSource(), whiteToTranspFilter);
         Image destImg2 = Toolkit.getDefaultToolkit().createImage(ip);


         coinIcon = new ImageIcon(destImg2);
         t = new Timer(1000, this);
         t.start();

      } catch (MalformedURLException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PAN_WIDTH, PAN_HT);
   }

   public void actionPerformed(ActionEvent e) {
      System.out.println("1 Second");

      Coin c = new Coin(random.nextInt(640), random.nextInt(480), coinIcon);
      add(c.getCoinLabel());
      revalidate();
      repaint();
   }

   public static void start(String[] args) {
      Coins coins = new Coins();
      JFrame frame = new JFrame("Coins");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(coins);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

}






class Coin {
   JLabel coinLabel = new JLabel();

   public Coin(int x1, int y1, ImageIcon coinIcon) {
      coinLabel.setIcon(coinIcon);
      coinLabel.setLocation(x1, y1);
      coinLabel.setSize(coinLabel.getPreferredSize());
   }

   public JLabel getCoinLabel() {
      return coinLabel;
   }

}