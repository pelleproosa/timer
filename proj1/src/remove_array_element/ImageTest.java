package remove_array_element;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageTest {

  public static void start(String[] args) {
    JPanel panel = new JPanel();
    ImageLabel label = new ImageLabel(new ImageIcon("D://temp/test.jpg"));
    label.setLocation(29, 37);
    panel.add(label);

    JFrame frame = new JFrame();
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}

class ImageLabel extends JLabel {

  public ImageLabel(String img) {
    this(new ImageIcon(img));
  }

  public ImageLabel(ImageIcon icon) {
    setIcon(icon);
    // setMargin(new Insets(0,0,0,0));
    setIconTextGap(0);
    // setBorderPainted(false);
    setBorder(null);
    setText(null);
    setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
  }

}
