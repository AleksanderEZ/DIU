package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconPanel extends JPanel {

    JLabel imageLabel;
    int width, height;

    public IconPanel() {
        setOpaque(false);
        imageLabel = new JLabel("No hay imagen");
        add(imageLabel);
    }

    public void setImage(BufferedImage image, int width) {
        removeAll();
        this.width = width;
        this.height = (width*image.getHeight())/image.getWidth();
        imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT)));
        add(imageLabel);
        setSize(width, height);
        updatePanel();
    }

    public void updatePanel() {
        revalidate();
        repaint();
    }
}
