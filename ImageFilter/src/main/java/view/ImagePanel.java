package view;

import control.UtilsPractica5;
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
        clearPanel();
        this.image = image;
        BufferedImage transformedImage = UtilsPractica5.seleccionarComponentes(image, !red, !green, !blue);
        System.out.println(transformedImage.getWidth() + ", " + transformedImage.getHeight());
        System.out.println(image.getWidth() + ", " + image.getHeight());
        this.width = width;
        this.height = (width*image.getHeight())/image.getWidth();
        imageLabel = new JLabel(new ImageIcon(transformedImage.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT)));
        add(imageLabel);
        setSize(width, height);
        updatePanel();
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public void clearPanel() {
        removeAll();
    }

    public void updatePanel() {
        revalidate();
        repaint();
    }
}
