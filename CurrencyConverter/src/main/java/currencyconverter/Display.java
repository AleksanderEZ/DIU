package currencyconverter;

import currencyconverter.model.*;

import com.formdev.flatlaf.FlatDarkLaf;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Display extends javax.swing.JFrame {

    DocumentListener euroInputListener, dollarInputListener;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    
    public Display() {
        setTitle("Conversor");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        initComponents();
        addDocumentListeners();
        setLookAndFeel();
    }
    
    public void run() {
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
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

    private void addDocumentListeners() {
        euroInputListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                processInput(euroInput, dollarInput, dollarInputListener);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                processInput(euroInput, dollarInput, dollarInputListener);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };
        euroInput.getDocument().addDocumentListener(euroInputListener);
        dollarInputListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                processInput(dollarInput, euroInput, euroInputListener);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                processInput(dollarInput, euroInput, euroInputListener);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };
        dollarInput.getDocument().addDocumentListener(dollarInputListener);
    }
    
    private void processInput(JTextField origin, JTextField destination, DocumentListener listener) {
        // Remove listener so that it won't react to our following change
        destination.getDocument().removeDocumentListener(listener);
        String text = origin.getText();
        text = text.replace(',', '.');
        try {
            double value = Double.parseDouble(text);
            if(origin.getName() == "euroInput"){
                value = new DolarEuro().getConversionRate();
            } else {
                value = new EuroDolar().getConversionRate();
            }
            destination.setText(decimalFormat.format(value));
            errorMessage.setVisible(false);
        } catch (NumberFormatException exception) {
            if (!text.equals("")) {
                errorMessage.setVisible(true);    
            }
        }
        destination.getDocument().addDocumentListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dollarInput;
    private javax.swing.JLabel dollarLabel;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextField euroInput;
    private javax.swing.JLabel euroLabel;
    // End of variables declaration//GEN-END:variables

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(getContentPane());
        }
        catch (Exception e) {
            System.out.println("Adding Look and Feel failed");
        }
    }
}
