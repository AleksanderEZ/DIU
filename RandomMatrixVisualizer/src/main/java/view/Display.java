/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Display extends javax.swing.JFrame {

    public Display() {
        initComponents();
        addDocumentListeners();
    }

    public void run() {
        this.setVisible(true);
    }
    
    private void addDocumentListeners() {
        maxValueInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    int maxValue = Integer.parseInt(maxValueInput.getText());
                    if (maxValue > minimumShownValue.getMinimum()) {
                        minimumShownValue.setMaximum(maxValue);
                        Display.this.setLabels(minimumShownValue, 10);
                        errorMessage.setVisible(false);
                    }
                } catch (NumberFormatException exception) {
                    errorMessage.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    int maxValue = Integer.parseInt(maxValueInput.getText());
                    if (maxValue > minimumShownValue.getMinimum()) {
                        minimumShownValue.setMaximum(maxValue);
                        Display.this.setLabels(minimumShownValue, 10);
                        errorMessage.setVisible(false);
                    }
                } catch (NumberFormatException exception) {
                    errorMessage.setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        });
        minValueInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    int minValue = Integer.parseInt(minValueInput.getText());
                    if (minValue < minimumShownValue.getMaximum()) {
                        minimumShownValue.setMinimum(minValue);
                        Display.this.setLabels(minimumShownValue, 10);
                        errorMessage.setVisible(false);
                    }
                } catch (NumberFormatException exception) {
                    errorMessage.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    int minValue = Integer.parseInt(minValueInput.getText());
                    if (minValue < minimumShownValue.getMaximum()) {
                        minimumShownValue.setMinimum(minValue);
                        Display.this.setLabels(minimumShownValue, 10);
                        errorMessage.setVisible(false);
                    }
                } catch (NumberFormatException exception) {
                    errorMessage.setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        });
    }
    
    private void setLabels(JSlider slider, int step) {
        double max = slider.getMaximum();
        double min = slider.getMinimum();
        double range = (max - min)/step;
        slider.setMajorTickSpacing((int) range);
        Hashtable<Integer, JLabel> table = new Hashtable<>();
        Integer prev = null;
        for (double i = min, j = 0; i <= max + 1; i += range, j++) {
            Integer current = (int) i;
            if (!current.equals(prev)) {
                table.put(current, new JLabel(current.toString()));
            }
        }
        slider.setLabelTable(table);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        matrixPanel = new javax.swing.JPanel();
        configPanel = new javax.swing.JPanel();
        minimumShownValue = new javax.swing.JSlider();
        rangeInputPanel = new javax.swing.JPanel();
        maxValueInput = new javax.swing.JTextField();
        minValueInput = new javax.swing.JTextField();
        maxValueLabel = new javax.swing.JLabel();
        minValueLabel = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Matriz aleatoria"); // NOI18N
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);

        matrixPanel.setToolTipText("");
        matrixPanel.setPreferredSize(new java.awt.Dimension(278, 278));

        javax.swing.GroupLayout matrixPanelLayout = new javax.swing.GroupLayout(matrixPanel);
        matrixPanel.setLayout(matrixPanelLayout);
        matrixPanelLayout.setHorizontalGroup(
            matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        matrixPanelLayout.setVerticalGroup(
            matrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        minimumShownValue.setMajorTickSpacing(10);
        minimumShownValue.setOrientation(javax.swing.JSlider.VERTICAL);
        minimumShownValue.setPaintLabels(true);
        minimumShownValue.setPaintTicks(true);
        minimumShownValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minimumShownValueStateChanged(evt);
            }
        });

        maxValueInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxValueInputActionPerformed(evt);
            }
        });

        maxValueLabel.setText("Valor máximo");

        minValueLabel.setText("Valor mínimo");

        errorMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        errorMessage.setText("Solo números sin coma");

        javax.swing.GroupLayout rangeInputPanelLayout = new javax.swing.GroupLayout(rangeInputPanel);
        rangeInputPanel.setLayout(rangeInputPanelLayout);
        rangeInputPanelLayout.setHorizontalGroup(
            rangeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rangeInputPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(rangeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minValueLabel)
                    .addComponent(maxValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rangeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maxValueInput)
                    .addComponent(minValueInput)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rangeInputPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(errorMessage)
                .addContainerGap())
        );
        rangeInputPanelLayout.setVerticalGroup(
            rangeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rangeInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rangeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxValueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rangeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minValueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(errorMessage)
                .addContainerGap())
        );

        errorMessage.setVisible(false);

        javax.swing.GroupLayout configPanelLayout = new javax.swing.GroupLayout(configPanel);
        configPanel.setLayout(configPanelLayout);
        configPanelLayout.setHorizontalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(minimumShownValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rangeInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        configPanelLayout.setVerticalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addComponent(minimumShownValue, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rangeInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(matrixPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(matrixPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maxValueInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxValueInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxValueInputActionPerformed

    private void minimumShownValueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minimumShownValueStateChanged
        System.out.println(minimumShownValue.getValue());
    }//GEN-LAST:event_minimumShownValueStateChanged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel configPanel;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JPanel matrixPanel;
    private javax.swing.JTextField maxValueInput;
    private javax.swing.JLabel maxValueLabel;
    private javax.swing.JTextField minValueInput;
    private javax.swing.JLabel minValueLabel;
    private javax.swing.JSlider minimumShownValue;
    private javax.swing.JPanel rangeInputPanel;
    // End of variables declaration//GEN-END:variables

    
}
