package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Stack;

public class ImagePanel extends JPanel {

    JLabel imageLabel;

    Stack<BufferedImage> previousImages;
    Stack<BufferedImage> nextImages;
    BufferedImage currentImage;

    public ImagePanel() {
        this.nextImages = new Stack<>();
        this.previousImages = new Stack<>();
        imageLabel = new JLabel();
        add(imageLabel);
    }

    public void setImage(BufferedImage image) {
        if (currentImage != null) {
            previousImages.add(currentImage);
        }
        removeAll();
        this.currentImage = image;

        int wi = image.getWidth();
        int hi = image.getHeight();
        int ws = 1024;
        int hs = 768;
        int ri = wi / hi;
        int rs = ws / hs;

        int width = (rs >= ri) ? wi * hs / hi : ws;
        int height = (rs >= ri) ? hs : hi * ws / wi;

        imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT)));
        add(imageLabel);
        Dimension size = new Dimension(width, height);
        setSize(size);
        updatePanel();
    }

    public void setPreviousImage() {
        if (!previousImages.isEmpty()) {
            nextImages.add(currentImage);
            setImageAlt(previousImages.pop());
        }
    }

    public void setNextImage() {
        if (!nextImages.isEmpty()) {
            previousImages.add(currentImage);
            setImageAlt(nextImages.pop());
        }
    }
    
    private void setImageAlt(BufferedImage image){
        removeAll();
        this.currentImage = image;

        int wi = image.getWidth();
        int hi = image.getHeight();
        int ws = 1024;
        int hs = 768;
        int ri = wi / hi;
        int rs = ws / hs;

        int width = (rs >= ri) ? wi * hs / hi : ws;
        int height = (rs >= ri) ? hs : hi * ws / wi;

        imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT)));
        add(imageLabel);
        Dimension size = new Dimension(width, height);
        setSize(size);
        updatePanel();
    }

    public BufferedImage getImage() {
        return currentImage;
    }

    public void updatePanel() {
        revalidate();
        repaint();
    }
}
