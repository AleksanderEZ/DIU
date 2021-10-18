package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private JLabel pictureLabel;

    public ImagePanel() {
        pictureLabel = new JLabel();
        add(pictureLabel);
        updatePanel();
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
        pictureLabel = new JLabel(new ImageIcon(image));
    }
    
    public void updatePanel() {
        revalidate();
        repaint();
    }
}