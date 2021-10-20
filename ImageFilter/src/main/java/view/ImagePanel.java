package view;

import control.UtilsPractica5;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    JLabel imageLabel;
    BufferedImage image;
    int width, height;

    public ImagePanel() {
        imageLabel = new JLabel("No hay imagen");
        add(imageLabel);
    }

    public void setImage(BufferedImage image, int width, boolean red, boolean green, boolean blue) {
        removeAll();
        this.image = image;
        BufferedImage transformedImage = UtilsPractica5.seleccionarComponentes(image, !red, !green, !blue);
        this.width = width;
        this.height = (width*image.getHeight())/image.getWidth();
        imageLabel = new JLabel(new ImageIcon(transformedImage.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT)));
        add(imageLabel);
        Dimension size = new Dimension(width, height);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
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
