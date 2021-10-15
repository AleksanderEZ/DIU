package view;

import control.UtilsPractica5;

public class Display extends javax.swing.JFrame {

    public Display() {
        initComponents();
    }
    
    public void run() {
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoGroup = new javax.swing.ButtonGroup();
        placeholder = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout placeholderLayout = new javax.swing.GroupLayout(placeholder);
        placeholder.setLayout(placeholderLayout);
        placeholderLayout.setHorizontalGroup(
            placeholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );
        placeholderLayout.setVerticalGroup(
            placeholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        getContentPane().add(placeholder, java.awt.BorderLayout.CENTER);

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
        topLeftButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoPanel.add(topLeftButton);

        logoGroup.add(topRightButton);
        topRightButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoPanel.add(topRightButton);

        logoGroup.add(bottomLeftButton);
        bottomLeftButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoPanel.add(bottomLeftButton);

        logoGroup.add(bottomRightButton);
        bottomRightButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoPanel.add(bottomRightButton);

        logoSettingsPanel.add(logoPanel);

        settingsPanel.add(logoSettingsPanel);

        getContentPane().add(settingsPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allColorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allColorsActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JCheckBox greenButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.ButtonGroup logoGroup;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel logoSettingsPanel;
    private javax.swing.JPanel logoTitlePanel;
    private javax.swing.JPanel placeholder;
    private javax.swing.JCheckBox redButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JRadioButton topLeftButton;
    private javax.swing.JRadioButton topRightButton;
    // End of variables declaration//GEN-END:variables
}
