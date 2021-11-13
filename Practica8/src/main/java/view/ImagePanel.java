package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Stack;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;

public class ImagePanel extends JInternalFrame {

    JLabel imageLabel;

    BufferedImage currentImage;

    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
    
    public ImagePanel(String name) {
        super(name, true,   // resizable
                    true,   // closable
                    true,   // maximizable
                    true);  // iconifiable
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
        imageLabel = new JLabel();
        getContentPane().add(imageLabel);
        setVisible(true);
        openFrameCount++;
        
        addInternalFrameListener(new InternalFrameListener() {
            public void internalFrameClosing(InternalFrameEvent e) {
                openFrameCount--;
                System.out.println("Closed window");
                dispose();
            }

            public void internalFrameClosed(InternalFrameEvent e) {
            }

            public void internalFrameOpened(InternalFrameEvent e) {
            }

            public void internalFrameIconified(InternalFrameEvent e) {
            }

            public void internalFrameDeiconified(InternalFrameEvent e) {
            }

            public void internalFrameActivated(InternalFrameEvent e) {
            }

            public void internalFrameDeactivated(InternalFrameEvent e) {
            }
        });
    }

    public void setImage(BufferedImage image) {
        getContentPane().removeAll();
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
        getContentPane().add(imageLabel);
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
        setVisible(true);
    }
    
    public static void resetFrameCount() {
        openFrameCount = 0;
    }
}
