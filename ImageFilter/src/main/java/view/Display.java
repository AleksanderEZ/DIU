package view;


import control.FileImageLoader;
import java.awt.image.BufferedImage;

public class Display extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoGroup = new javax.swing.ButtonGroup();
        colorGroup = new javax.swing.ButtonGroup();
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
        display = new javax.swing.JLayeredPane();
        backgroundPanel = new view.ImagePanel();
        iconPanel = new view.IconPanel();

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

        colorGroup.add(redButton);
        redButton.setText("Rojo");
        colorPanel.add(redButton);

        colorGroup.add(greenButton);
        greenButton.setText("Verde");
        colorPanel.add(greenButton);

        colorGroup.add(blueButton);
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

        viewPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        display.add(backgroundPanel);
        backgroundPanel.setBounds(0, 0, 660, 260);

        javax.swing.GroupLayout iconPanelLayout = new javax.swing.GroupLayout(iconPanel);
        iconPanel.setLayout(iconPanelLayout);
        iconPanelLayout.setHorizontalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );
        iconPanelLayout.setVerticalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        display.setLayer(iconPanel, javax.swing.JLayeredPane.DRAG_LAYER);
        display.add(iconPanel);
        iconPanel.setBounds(0, 0, 658, 255);

        viewPanel.add(display, java.awt.BorderLayout.CENTER);

        getContentPane().add(viewPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allColorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allColorsActionPerformed
        
    }//GEN-LAST:event_allColorsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox allColors;
    private view.ImagePanel backgroundPanel;
    private javax.swing.JCheckBox blueButton;
    private javax.swing.JRadioButton bottomLeftButton;
    private javax.swing.JRadioButton bottomRightButton;
    private javax.swing.ButtonGroup colorGroup;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JPanel colorSettingsPanel;
    private javax.swing.JLabel colorTitle;
    private javax.swing.JPanel colorTitlePanel;
    private javax.swing.JLayeredPane display;
    private javax.swing.JCheckBox greenButton;
    private view.IconPanel iconPanel;
    private javax.swing.JLabel jLabel1;
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
    
    // Las rutas tienen que estar relativas a la carpeta madre de en la que esté 
    // FileImageLoader.class, osea en DIU/ImageFilter/target/classes
    private final String PATH_TO_LOGO_IMAGE = 
            "assets/fishlogo.png";
    private final String PATH_TO_BACKGROUND_IMAGE =
            "assets/background.jpg";
    private final int ICON_ROWS = 2;
    private final int ICON_COLUMNS = 2;
    
    public Display() {
        initComponents();
        setUpViewPanels();
        setVisible(true);
    }
    
    private void setUpViewPanels() {
        int activePositionButton = getSelectedButton();
        BufferedImage backgroundImage = new FileImageLoader(PATH_TO_BACKGROUND_IMAGE).load();
        BufferedImage logoImage = new FileImageLoader(PATH_TO_LOGO_IMAGE).load();
        
        backgroundPanel.setImage(backgroundImage);
        
        iconPanel.setImage(logoImage);
        iconPanel.setPosition(activePositionButton);
        
        repaintDisplay();
    }
    
    private int getSelectedButton() {
        int selection = Character.getNumericValue(logoGroup.getSelection().getMnemonic());
        return selection;
    }

    private void repaintDisplay() {
        backgroundPanel.updatePanel();
        iconPanel.updatePanel();
        display.revalidate();
        display.repaint();
    }
}

/*       _
       .__(.)< (MIAU)
        \___)   
*/