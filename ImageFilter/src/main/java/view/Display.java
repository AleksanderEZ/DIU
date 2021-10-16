package view;

import control.FileImageLoader;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Display extends javax.swing.JFrame {
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
        display = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        settingsPanel.setLayout(new javax.swing.BoxLayout(settingsPanel, javax.swing.BoxLayout.LINE_AXIS));

        colorSettingsPanel.setLayout(new javax.swing.BoxLayout(colorSettingsPanel, javax.swing.BoxLayout.PAGE_AXIS));

        colorTitlePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        colorTitlePanel.setLayout(new javax.swing.BoxLayout(colorTitlePanel, javax.swing.BoxLayout.LINE_AXIS));

        colorTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        colorTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colorTitle.setText("Color del fondo");
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
        colorPanel.add(redButton);

        greenButton.setText("Verde");
        colorPanel.add(greenButton);

        blueButton.setText("Azul");
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
        logoPanel.add(topLeftButton);

        logoGroup.add(topRightButton);
        topRightButton.setMnemonic('1');
        topRightButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoPanel.add(topRightButton);

        logoGroup.add(bottomLeftButton);
        bottomLeftButton.setMnemonic('2');
        bottomLeftButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoPanel.add(bottomLeftButton);

        logoGroup.add(bottomRightButton);
        bottomRightButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoPanel.add(bottomRightButton);

        logoSettingsPanel.add(logoPanel);

        settingsPanel.add(logoSettingsPanel);

        getContentPane().add(settingsPanel, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout displayLayout = new javax.swing.GroupLayout(display);
        display.setLayout(displayLayout);
        displayLayout.setHorizontalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );
        displayLayout.setVerticalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        getContentPane().add(display, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allColorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allColorsActionPerformed
    }//GEN-LAST:event_allColorsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox allColors;
    private javax.swing.JCheckBox blueButton;
    private javax.swing.JRadioButton bottomLeftButton;
    private javax.swing.JRadioButton bottomRightButton;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JPanel colorSettingsPanel;
    private javax.swing.JLabel colorTitle;
    private javax.swing.JPanel colorTitlePanel;
    private javax.swing.JLayeredPane display;
    private javax.swing.JCheckBox greenButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.ButtonGroup logoGroup;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel logoSettingsPanel;
    private javax.swing.JPanel logoTitlePanel;
    private javax.swing.JCheckBox redButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JRadioButton topLeftButton;
    private javax.swing.JRadioButton topRightButton;
    // End of variables declaration//GEN-END:variables
    
    private final String PATH_TO_LOGO_IMAGE = 
            "F:\\Users\\Nueva carpeta\\DIU\\Prácticas\\DIU\\ImageFilter\\src\\main\\java\\view\\fishlogo.png";
    private final String PATH_TO_BACKGROUND_IMAGE =
            "F:\\Users\\Nueva carpeta\\DIU\\Prácticas\\DIU\\ImageFilter\\src\\main\\java\\view\\background.jpg";
    private final int ICON_ROWS = 2;
    private final int ICON_COLUMNS = 2;
    private ImagePanel backgroundPanel;
    private IconPanel frontPanel;
    
    public Display() {
        initComponents();
        layeredPaneLayering();
        
        setVisible(true);
    }
    
    private void layeredPaneLayering() {
        int activePositionButton = getSelectedButton();
        BufferedImage backgroundImage = new FileImageLoader(PATH_TO_BACKGROUND_IMAGE).load();
        BufferedImage logoImage = new FileImageLoader(PATH_TO_LOGO_IMAGE).load();
        
        backgroundPanel = new ImagePanel(backgroundImage);
        frontPanel = new IconPanel(activePositionButton, logoImage, ICON_ROWS, ICON_COLUMNS);
        display.add(backgroundPanel, 0);
        display.add(frontPanel, 1);
        backgroundPanel.updatePanel();
        frontPanel.updatePanel();
        repaintDisplay();
    }
    
    private int getSelectedButton() {
        int selection = Character.getNumericValue(logoGroup.getSelection().getMnemonic());
        return selection;
    }

    private void repaintDisplay() {
        display.revalidate();
        display.repaint();
    }
}
