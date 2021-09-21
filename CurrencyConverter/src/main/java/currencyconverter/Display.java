package currencyconverter;

import currencyconverter.model.*;

import com.formdev.flatlaf.FlatDarkLaf;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class Display extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        euroInput = new javax.swing.JTextField();
        dollarInput = new javax.swing.JTextField();
        euroLabel = new javax.swing.JLabel();
        dollarLabel = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(240, 180));
        setMinimumSize(new java.awt.Dimension(240, 180));
        setResizable(false);

        euroInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                euroInputActionPerformed(evt);
            }
        });

        dollarInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dollarInputActionPerformed(evt);
            }
        });

        euroLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        euroLabel.setText("€");

        dollarLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dollarLabel.setText("$");

        errorMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 0, 0));
        errorMessage.setText("Solo se puede escribir números");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorMessage)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(euroInput, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(euroLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(dollarInput, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(dollarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(euroInput)
                    .addComponent(euroLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dollarInput, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(dollarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(errorMessage)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        errorMessage.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void euroInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_euroInputActionPerformed
    }//GEN-LAST:event_euroInputActionPerformed

    private void dollarInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dollarInputActionPerformed
    }//GEN-LAST:event_dollarInputActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dollarInput;
    private javax.swing.JLabel dollarLabel;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextField euroInput;
    private javax.swing.JLabel euroLabel;
    // End of variables declaration//GEN-END:variables
    DocumentListener euroInputListener, dollarInputListener;
    private final int CHAR_LIMIT = 100;

    public Display() {
        setTitle("Conversor");
        initComponents();
        addDocumentListeners();
        setLookAndFeel();
    }

    public void run() {
        setVisible(true);
    }

    private void addDocumentListeners() {
        euroInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                displayConvertedValueInTheOtherTextbox(e, true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                displayConvertedValueInTheOtherTextbox(e, true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        dollarInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                displayConvertedValueInTheOtherTextbox(e, false);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                displayConvertedValueInTheOtherTextbox(e, false);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    private void displayConvertedValueInTheOtherTextbox(DocumentEvent e, boolean isEuroInput) {
        String text = "";
        try {
            int length = e.getDocument().getLength();
            text = e.getDocument().getText(0, length);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        text = text.replace(',', '.');
        
        try {
            float value = Float.parseFloat(text);
            errorMessage.setVisible(false);
            convertAndDisplay(value, isEuroInput);
        } catch (NumberFormatException ex) {
            text.replaceAll("[^\\d.]", "");
            setTextTo(isEuroInput, text);
            errorMessage.setVisible(true);
        }

    }

    private void convertAndDisplay(float amount, boolean isEuroInput) {
        String amountText;
        if (isEuroInput) {
            float euroToDolarConversionRate = new EuroDolar().getConversionRate();
            Float amountInDollars = euroToDolarConversionRate * amount;
            amountText = amountInDollars.toString();
        } else {
            float dollarToEuroConversionRate = new DolarEuro().getConversionRate();
            Float amountInEuros = dollarToEuroConversionRate * amount;
            amountText = amountInEuros.toString();
        }
        amountText = amountText.substring(0, amountText.indexOf('.') + 3);
        setTextTo(!isEuroInput, amountText);
    }

    private void setInputBlank(boolean isEuroInput) {
        if (isEuroInput) {
            euroInput.setText("");
        } else {
            dollarInput.setText("");
        }
    }
    
    private void setTextTo(boolean isEuroInput, String text) {
        if (isEuroInput) {
            euroInput.setText(text);
        } else {
            dollarInput.setText(text);
        }
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(getContentPane());
        } catch (Exception e) {
            System.out.println("Adding Look and Feel failed");
        }
    }
}
