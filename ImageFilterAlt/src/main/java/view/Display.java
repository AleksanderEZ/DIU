package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Display extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settingsPanel = new javax.swing.JPanel();
        display = new javax.swing.JLayeredPane();
        iconPanel = new view.iconPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(settingsPanel, java.awt.BorderLayout.PAGE_START);

        display.setLayout(new java.awt.BorderLayout());
        display.add(iconPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(display, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane display;
    private view.iconPanel iconPanel;
    private javax.swing.JPanel settingsPanel;
    // End of variables declaration//GEN-END:variables
    
    
    public Display() {
        initComponents();
        loadAndShowImage();
        setVisible(true);
    }

    private void loadAndShowImage() {
        iconPanel.setImage(getImage());
        iconPanel.update();
        revalidate();
        repaint();
    }

    private BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("F:\\Users\\Nueva carpeta\\DIU\\Prácticas\\DIU\\ImageFilter\\src\\main\\java\\view\\background.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }
}
