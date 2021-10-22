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
        
        int wi = image.getWidth();
        int hi = image.getHeight();
        int ws = 1024;
        int hs = 768;
        int ri = wi/hi;
        int rs = ws/hs;
        
        int width = (rs >= ri) ? wi * hs/hi : ws;
        int height = (rs >= ri) ? hs : hi * ws/wi;
        
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