package currencyconverter;

import currencyconverter.model.*;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class Display extends javax.swing.JFrame {

    private final int MAX_DECIMAL_DIGITS = 2;

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dollarInput;
    private javax.swing.JLabel dollarLabel;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextField euroInput;
    private javax.swing.JLabel euroLabel;
    // End of variables declaration//GEN-END:variables
    DocumentListener euroInputListener, dollarInputListener;

    public Display() {
        setTitle("Conversor");
        initComponents();
        addDocumentListeners();
        setLookAndFeel();
    }

    public void run() {
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(getContentPane());
    }

    private void addDocumentListeners() {
        euroInputListener = getEuroListener();
        dollarInputListener = getDollarListener();
        addEuroListener();
        addDollarListener();
    }

    private DocumentListener getEuroListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                removeDollarListener();
                displayConvertedValueInTheOtherTextbox(e, true);
                addDollarListener();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                removeDollarListener();
                displayConvertedValueInTheOtherTextbox(e, true);
                addDollarListener();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };
    }

    private DocumentListener getDollarListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                removeEuroListener();
                displayConvertedValueInTheOtherTextbox(e, false);
                addEuroListener();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                removeEuroListener();
                displayConvertedValueInTheOtherTextbox(e, false);
                addEuroListener();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };
    }

    private void removeEuroListener() {
        euroInput.getDocument().removeDocumentListener(euroInputListener);
    }
    
    private void removeDollarListener() {
        dollarInput.getDocument().removeDocumentListener(dollarInputListener);
    }
    
    private void addEuroListener() {
        euroInput.getDocument().addDocumentListener(euroInputListener);
    }

    private void addDollarListener() {
        dollarInput.getDocument().addDocumentListener(dollarInputListener);
    }

    private void displayConvertedValueInTheOtherTextbox(DocumentEvent e, boolean isEuroInput) {

        String text = getTextFromInput(e);
        
        if (text.isEmpty() == false) {
            text = Converter.decimalDotSeparation(text);
            Float extractedNumber = getNumberFromText(text);

            if (extractedNumber != null) {
                errorMessage.setVisible(false);
                display(extractedNumber, isEuroInput);
            } else {
                errorMessage.setVisible(true);
                setInputBlank(!isEuroInput);
            }
        } else {
            setInputBlank(!isEuroInput);
        }
    }

    private String getTextFromInput(DocumentEvent e) {
        String text;
        try {
            int length = e.getDocument().getLength();
            text = e.getDocument().getText(0, length);
        } catch (BadLocationException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            text = null;
        }
        return text;
    }

    private Float getNumberFromText(String text) {
        Float value;
        try {
            value = Float.parseFloat(text);
        } catch (NumberFormatException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            value = null;
        }
        return value;
    }

    private void display(Float amount, boolean isEuroInput) {
        
        if (isEuroInput) {
            amount = Converter.convertEurosToDollars(amount);
        } else {
            amount = Converter.convertDollarsToEuros(amount);
        }
        
        String amountText = amount.toString();
        amountText = amountText.substring(0, amountText.indexOf('.') + MAX_DECIMAL_DIGITS + 1);
        setInputTextTo(!isEuroInput, amountText);
    }

    private void setInputBlank(boolean isEuroInput) {
        if (isEuroInput) {
            euroInput.setText("");
        } else {
            dollarInput.setText("");
        }
    }

    private void setInputTextTo(boolean isEuroInput, String text) {
        if (isEuroInput) {
            euroInput.setText(text);
        } else {
            dollarInput.setText(text);
        }
    }
}
