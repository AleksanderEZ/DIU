package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconPanel extends JPanel {

    JLabel imageLabel;

    public IconPanel() {
        setOpaque(false);
        imageLabel = new JLabel("No hay imagen");
        add(imageLabel);
    }

    public void setImage(BufferedImage image) {
        clearPanel();
        imageLabel = new JLabel(new ImageIcon(image));
        add(imageLabel);
        resizePanel(image);
        updatePanel();
    }

    public void clearPanel() {
        removeAll();
    }

    public void updatePanel() {
        revalidate();
        repaint();
    }

    private void resizePanel(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        setSize(width, height);
    }

}
