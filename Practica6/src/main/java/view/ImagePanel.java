package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    JLabel imageLabel;
    BufferedImage image;

    public ImagePanel() {
        imageLabel = new JLabel();
        add(imageLabel);
    }

    public void setImage(BufferedImage image) {
        removeAll();
        this.image = image;
        int width = image.getWidth();
        int height = image.getHeight();
        if (width < height && height > 768) {
            height = 768;
            width = (height*image.getWidth())/image.getHeight();
        } else if (width > 1024) {
            width = 1024;
            height = (width*image.getHeight())/image.getWidth();
        }
        
        imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT)));
        add(imageLabel);
        Dimension size = new Dimension(width, height);
        setSize(size);
        updatePanel();
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public void updatePanel() {
        revalidate();
        repaint();
    }
}