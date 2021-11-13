package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Display extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        connectionPanel = new javax.swing.JPanel();
        connectionLabelAndField = new javax.swing.JPanel();
        connectionLabel = new javax.swing.JLabel();
        connectionField = new javax.swing.JTextField();
        userPanel = new javax.swing.JPanel();
        userLabelAndField = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passwordPanel = new javax.swing.JPanel();
        passwordLabelAndField = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Explorador de bases de datos");

        loginPanel.setLayout(new java.awt.GridLayout(3, 1));

        connectionPanel.setLayout(new java.awt.GridBagLayout());

        connectionLabelAndField.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        connectionLabel.setText("URL de conexión: ");
        connectionLabelAndField.add(connectionLabel);

        connectionField.setColumns(30);
        connectionField.setText(" mozart.dis.ulpgc.es/DIU_BD?useSSL=true");
        connectionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionFieldActionPerformed(evt);
            }
        });
        connectionLabelAndField.add(connectionField);

        connectionPanel.add(connectionLabelAndField, new java.awt.GridBagConstraints());

        loginPanel.add(connectionPanel);

        userPanel.setLayout(new java.awt.GridBagLayout());

        userLabelAndField.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        userLabel.setText("Usuario: ");
        userLabelAndField.add(userLabel);

        userField.setColumns(30);
        userField.setText("estudiante-DIU");
        userLabelAndField.add(userField);

        userPanel.add(userLabelAndField, new java.awt.GridBagConstraints());

        loginPanel.add(userPanel);

        passwordPanel.setLayout(new java.awt.GridBagLayout());

        passwordLabelAndField.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        passwordLabel.setText("Contraseña: ");
        passwordLabelAndField.add(passwordLabel);

        passwordField.setColumns(30);
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setText("Clave prácticas");
        passwordLabelAndField.add(passwordField);

        passwordPanel.add(passwordLabelAndField, new java.awt.GridBagConstraints());

        loginPanel.add(passwordPanel);

        getContentPane().add(loginPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionFieldActionPerformed

    public Display() {
        setLookAndFeel();
        initComponents();
        run();
    }

    public void run() {
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField connectionField;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JPanel connectionLabelAndField;
    private javax.swing.JPanel connectionPanel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel passwordLabelAndField;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    private javax.swing.JPanel userLabelAndField;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
