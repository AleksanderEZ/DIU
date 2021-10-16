package view;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(BufferedImage image) {
        this.image = image;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public void updatePanel() {
        revalidate();
        repaint();
    }
}
