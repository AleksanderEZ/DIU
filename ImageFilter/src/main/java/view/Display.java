package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.image.BufferedImage;
import control.FileImageLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Display extends javax.swing.JFrame {

    private final String fishLogoPath = "assets/fishlogo.png";
    private final String backgroundImagePath = "assets/background.jpg";
    private final int backgroundWidth = 640;
    private final int iconWidth = 100;
    private BufferedImage backgroundImage;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoGroup = new javax.swing.ButtonGroup();
        settingsPanel = new javax.swing.JPanel();
        colorSettingsPanel = new javax.swing.JPanel();
        colorTitlePanel = new javax.swing.JPanel();
        colorTitle = new javax.swing.JLabel();
        colorPanel = new javax.swing.JPanel();
        allColors = new javax.swing.JCheckBox();
        redButton = new javax.swing.JCheckBox();
        greenButton = new javax.swing.JCheckBox();
        blueButton = new javax.swing.JCheckBox();
        logoSettingsPanel = new javax.swing.JPanel();
        logoTitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logoPanel = new javax.swing.JPanel();
        topLeftButton = new javax.swing.JRadioButton();
        topRightButton = new javax.swing.JRadioButton();
        bottomLeftButton = new javax.swing.JRadioButton();
        bottomRightButton = new javax.swing.JRadioButton();
        viewPanel = new javax.swing.JPanel();
        layers = new javax.swing.JLayeredPane();
        imagePanel = new view.ImagePanel();
        iconPanel = new view.IconPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Image Filter"); // NOI18N
        setResizable(false);

        settingsPanel.setLayout(new javax.swing.BoxLayout(settingsPanel, javax.swing.BoxLayout.LINE_AXIS));

        colorSettingsPanel.setLayout(new javax.swing.BoxLayout(colorSettingsPanel, javax.swing.BoxLayout.PAGE_AXIS));

        colorTitlePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        colorTitlePanel.setLayout(new javax.swing.BoxLayout(colorTitlePanel, javax.swing.BoxLayout.LINE_AXIS));

        colorTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        colorTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colorTitle.setText("Filtrar color del fondo");
        colorTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorTitlePanel.add(colorTitle);

        colorSettingsPanel.add(colorTitlePanel);

        colorPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        allColors.setText("Todo");
        allColors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allColorsActionPerformed(evt);
            }
        });
        colorPanel.add(allColors);

        redButton.setText("Rojo");
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });
        colorPanel.add(redButton);

        greenButton.setText("Verde");
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });
        colorPanel.add(greenButton);

        blueButton.setText("Azul");
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });
        colorPanel.add(blueButton);

        colorSettingsPanel.add(colorPanel);

        settingsPanel.add(colorSettingsPanel);

        logoSettingsPanel.setLayout(new javax.swing.BoxLayout(logoSettingsPanel, javax.swing.BoxLayout.PAGE_AXIS));

        logoTitlePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoTitlePanel.setLayout(new javax.swing.BoxLayout(logoTitlePanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Posición del pez");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoTitlePanel.add(jLabel1);

        logoSettingsPanel.add(logoTitlePanel);

        logoPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoPanel.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        logoGroup.add(topLeftButton);
        topLeftButton.setMnemonic('0');
        topLeftButton.setSelected(true);
        topLeftButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topLeftButtonActionPerformed(evt);
            }
        });
        logoPanel.add(topLeftButton);

        logoGroup.add(topRightButton);
        topRightButton.setMnemonic('1');
        topRightButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topRightButtonActionPerformed(evt);
            }
        });
        logoPanel.add(topRightButton);

        logoGroup.add(bottomLeftButton);
        bottomLeftButton.setMnemonic('2');
        bottomLeftButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bottomLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottomLeftButtonActionPerformed(evt);
            }
        });
        logoPanel.add(bottomLeftButton);

        logoGroup.add(bottomRightButton);
        bottomRightButton.setMnemonic('3');
        bottomRightButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bottomRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottomRightButtonActionPerformed(evt);
            }
        });
        logoPanel.add(bottomRightButton);

        logoSettingsPanel.add(logoPanel);

        settingsPanel.add(logoSettingsPanel);

        getContentPane().add(settingsPanel, java.awt.BorderLayout.PAGE_START);

        viewPanel.setLayout(new java.awt.BorderLayout());

        layers.add(imagePanel);
        imagePanel.setBounds(0, 4, 415, 210);
        layers.add(iconPanel);
        iconPanel.setBounds(0, 0, 410, 220);

        viewPanel.add(layers, java.awt.BorderLayout.CENTER);

        getContentPane().add(viewPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allColorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allColorsActionPerformed
        if (allColors.isSelected()) {
            redButton.setSelected(true);
            greenButton.setSelected(true);
            blueButton.setSelected(true);
        }
        imagePanel.setImage(imagePanel.getImage(), backgroundWidth, redButton.isSelected(), 
                        greenButton.isSelected(), blueButton.isSelected());
        updatePanel();
    }//GEN-LAST:event_allColorsActionPerformed

    private void topLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topLeftButtonActionPerformed
        iconPanel.setLocation(0, 0);
    }//GEN-LAST:event_topLeftButtonActionPerformed

    private void topRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topRightButtonActionPerformed
        iconPanel.setLocation(imagePanel.getWidth() - iconPanel.getWidth(), 0);
    }//GEN-LAST:event_topRightButtonActionPerformed

    private void bottomLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottomLeftButtonActionPerformed
        iconPanel.setLocation(0, imagePanel.getHeight() - iconPanel.getHeight());
    }//GEN-LAST:event_bottomLeftButtonActionPerformed

    private void bottomRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottomRightButtonActionPerformed
        iconPanel.setLocation(imagePanel.getWidth() - iconPanel.getWidth(), 
                imagePanel.getHeight() - iconPanel.getHeight());
    }//GEN-LAST:event_bottomRightButtonActionPerformed

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButtonActionPerformed
        imagePanel.setImage(imagePanel.getImage(), backgroundWidth, redButton.isSelected(), 
                        greenButton.isSelected(), blueButton.isSelected());
        updatePanel();
    }//GEN-LAST:event_redButtonActionPerformed

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenButtonActionPerformed
        imagePanel.setImage(imagePanel.getImage(), backgroundWidth, redButton.isSelected(), 
                        greenButton.isSelected(), blueButton.isSelected());
        updatePanel();
    }//GEN-LAST:event_greenButtonActionPerformed

    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueButtonActionPerformed
        imagePanel.setImage(imagePanel.getImage(), backgroundWidth, redButton.isSelected(), 
                        greenButton.isSelected(), blueButton.isSelected());
        updatePanel();
    }//GEN-LAST:event_blueButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox allColors;
    private javax.swing.JCheckBox blueButton;
    private javax.swing.JRadioButton bottomLeftButton;
    private javax.swing.JRadioButton bottomRightButton;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JPanel colorSettingsPanel;
    private javax.swing.JLabel colorTitle;
    private javax.swing.JPanel colorTitlePanel;
    private javax.swing.JCheckBox greenButton;
    private view.IconPanel iconPanel;
    private view.ImagePanel imagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane layers;
    private javax.swing.ButtonGroup logoGroup;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel logoSettingsPanel;
    private javax.swing.JPanel logoTitlePanel;
    private javax.swing.JCheckBox redButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JRadioButton topLeftButton;
    private javax.swing.JRadioButton topRightButton;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
    
    public Display() {
        setLookAndFeel();
        initComponents();
        iconPanelSetUp();
        imagePanelSetUp();
        setTitle("Filtro de imagen");
    }

    public void run() {
        setVisible(true);
    }

    private void updatePanel() {
        revalidate();
        repaint();
    }

    private BufferedImage getImageFromPath(String path) {
        return new FileImageLoader().load(path);
    }

    private void iconPanelSetUp() {
        BufferedImage iconImage = getImageFromPath(fishLogoPath);
        iconPanel.setImage(iconImage, iconWidth);
        layers.setLayer(iconPanel, 2);
        updatePanel();
    }

    private void imagePanelSetUp() {
        backgroundImage = getImageFromPath(backgroundImagePath);
        imagePanel.setImage(backgroundImage, backgroundWidth, false, false, false);
        layers.setLayer(imagePanel, 1);
        resizePanel(backgroundImage);
        updatePanel();
    }

    private void resizePanel(BufferedImage image) {
        setSize(backgroundWidth + 15, imagePanel.getHeight() + 143);
        System.out.println(getSize());
        setMaximumSize(getSize());
        setPreferredSize(getSize());
        setMinimumSize(getSize());
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
