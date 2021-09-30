/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.MatrixModelator;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Display extends javax.swing.JFrame {

    MatrixPanel matrixPanel;
    MatrixModelator modelator;
    
    public Display() {
        initComponents();
        addDocumentListeners();
        modelator = new MatrixModelator();
        modelator.setMaxMatrixValue(minimumShownValue.getMaximum());
        modelator.setMinMatrixValue(minimumShownValue.getMinimum());
        modelator.generate();
        setMatrixPanel();
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
        for (double i = min, j = 0; i <= max; i += range, j++) {
            Integer current = (int) i;
            if (!current.equals(prev)) {
                table.put(current, new JLabel(current.toString()));
            }
        }
        slider.setLabelTable(table);
    }
    
    private void setMatrixPanel() {
        matrixPanel = modelator.getMatrixPanel(minimumShownValue.getValue());
        
        getContentPane().removeAll();
        getContentPane().add(matrixPanel);
        getContentPane().add(configPanel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        configPanel = new javax.swing.JPanel();
        sliderPanel = new javax.swing.JPanel();
        minimumShownValue = new javax.swing.JSlider();
        rangeInputPanel = new javax.swing.JPanel();
        maxValue = new javax.swing.JPanel();
        maxValueLabel = new javax.swing.JLabel();
        maxValueInput = new javax.swing.JTextField();
        minValue = new javax.swing.JPanel();
        minValueLabel = new javax.swing.JLabel();
        minValueInput = new javax.swing.JTextField();
        errorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Matriz aleatoria"); // NOI18N
        setPreferredSize(new java.awt.Dimension(640, 480));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {4};
        layout.rowHeights = new int[] {3};
        getContentPane().setLayout(layout);

        configPanel.setLayout(new javax.swing.BoxLayout(configPanel, javax.swing.BoxLayout.PAGE_AXIS));

        sliderPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        minimumShownValue.setMajorTickSpacing(10);
        minimumShownValue.setOrientation(javax.swing.JSlider.VERTICAL);
        minimumShownValue.setPaintLabels(true);
        minimumShownValue.setPaintTicks(true);
        minimumShownValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minimumShownValueStateChanged(evt);
            }
        });

        javax.swing.GroupLayout sliderPanelLayout = new javax.swing.GroupLayout(sliderPanel);
        sliderPanel.setLayout(sliderPanelLayout);
        sliderPanelLayout.setHorizontalGroup(
            sliderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
            .addGroup(sliderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sliderPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(minimumShownValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        sliderPanelLayout.setVerticalGroup(
            sliderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(sliderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sliderPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(minimumShownValue, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        configPanel.add(sliderPanel);

        rangeInputPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rangeInputPanel.setLayout(new javax.swing.BoxLayout(rangeInputPanel, javax.swing.BoxLayout.PAGE_AXIS));

        maxValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 15, 25, 15));
        maxValue.setLayout(new javax.swing.BoxLayout(maxValue, javax.swing.BoxLayout.LINE_AXIS));

        maxValueLabel.setText("Valor máximo");
        maxValueLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        maxValue.add(maxValueLabel);

        maxValueInput.setBorder(null);
        maxValueInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxValueInputActionPerformed(evt);
            }
        });
        maxValue.add(maxValueInput);

        rangeInputPanel.add(maxValue);

        minValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 15, 25, 15));
        minValue.setLayout(new javax.swing.BoxLayout(minValue, javax.swing.BoxLayout.LINE_AXIS));

        minValueLabel.setText("Valor mínimo");
        minValueLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        minValue.add(minValueLabel);

        minValueInput.setBorder(null);
        minValue.add(minValueInput);

        rangeInputPanel.add(minValue);

        errorMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        errorMessage.setText("Solo números sin coma");
        rangeInputPanel.add(errorMessage);
        errorMessage.setVisible(false);

        configPanel.add(rangeInputPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 10);
        getContentPane().add(configPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maxValueInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxValueInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxValueInputActionPerformed

    private void minimumShownValueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minimumShownValueStateChanged
        setMatrixPanel();
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
    private javax.swing.JPanel maxValue;
    private javax.swing.JTextField maxValueInput;
    private javax.swing.JLabel maxValueLabel;
    private javax.swing.JPanel minValue;
    private javax.swing.JTextField minValueInput;
    private javax.swing.JLabel minValueLabel;
    private javax.swing.JSlider minimumShownValue;
    private javax.swing.JPanel rangeInputPanel;
    private javax.swing.JPanel sliderPanel;
    // End of variables declaration//GEN-END:variables

}
