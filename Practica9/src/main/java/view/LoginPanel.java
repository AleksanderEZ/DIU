package view;

import controller.DatabaseController;
import javax.swing.SwingUtilities;

public class LoginPanel extends javax.swing.JPanel {

    Display window;
    DatabaseController dbController;
    char echoChar;
    
    public LoginPanel(Display window) {
        initComponents();
        this.window = window;
        dbController = new DatabaseController();
        echoChar = passwordField.getEchoChar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        serverPanel = new javax.swing.JPanel();
        serverLabel = new javax.swing.JLabel();
        serverField = new javax.swing.JTextField();
        databasePanel = new javax.swing.JPanel();
        databaseLabel = new javax.swing.JLabel();
        databaseField = new javax.swing.JTextField();
        userPanel = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passwordPanel = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField(20);
        showPasswordButton = new javax.swing.JCheckBox();
        connectPanel = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        connectingLabel = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {1};
        layout.rowHeights = new int[] {2};
        layout.columnWeights = new double[] {1.0};
        layout.rowWeights = new double[] {2.0};
        setLayout(layout);

        loginPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        loginPanel.setAlignmentX(0.0F);
        loginPanel.setAlignmentY(0.0F);
        loginPanel.setLayout(new javax.swing.BoxLayout(loginPanel, javax.swing.BoxLayout.PAGE_AXIS));

        serverPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        serverLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        serverLabel.setText("Servidor");
        serverPanel.add(serverLabel);

        serverField.setColumns(30);
        serverField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        serverField.setText("i7-lab5.dis.ulpgc.es");
        serverPanel.add(serverField);

        loginPanel.add(serverPanel);

        databasePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        databaseLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        databaseLabel.setText("Base de datos");
        databasePanel.add(databaseLabel);

        databaseField.setColumns(30);
        databaseField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        databaseField.setText("DIU_BD");
        databasePanel.add(databaseField);

        loginPanel.add(databasePanel);

        userPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        userLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userLabel.setText("Usuario: ");
        userPanel.add(userLabel);

        userField.setColumns(30);
        userField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userField.setText("estudiante-DIU");
        userField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFieldActionPerformed(evt);
            }
        });
        userPanel.add(userField);

        loginPanel.add(userPanel);

        passwordPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordLabel.setText("Contraseña: ");
        passwordPanel.add(passwordLabel);

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordField.setText("Diu_2021_22");
        passwordPanel.add(passwordField);

        showPasswordButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showPasswordButton.setText("Mostrar");
        showPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordButtonActionPerformed(evt);
            }
        });
        passwordPanel.add(showPasswordButton);

        loginPanel.add(passwordPanel);

        connectButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        connectButton.setText("Conectar");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        connectPanel.add(connectButton);

        connectingLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        connectingLabel.setText("Conectando...");
        connectPanel.add(connectingLabel);
        connectingLabel.setVisible(false);

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 50, 50));
        errorLabel.setText("Ocurrió un error al conectar con la base de datos");
        connectPanel.add(errorLabel);
        errorLabel.setVisible(false);

        loginPanel.add(connectPanel);

        add(loginPanel, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    
    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // Conectar con la base de datos. 
        // Si conecta, cambiar este JPanel por el JPanel de mostrar datos, repaint, revalidate
        connectingLabel.setVisible(true);
        errorLabel.setVisible(false);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (  dbController.connect(serverField.getText(), 
                    databaseField.getText(), 
                    userField.getText(), 
                    String.valueOf(passwordField.getPassword()))) {
                    window.setDatabasePanel(dbController);
                } else {
                    errorLabel.setVisible(true);
                    System.out.println("Ocurrió un error al acceder a la base de datos");
                }
                connectingLabel.setVisible(false);
            }
          });
        
    }//GEN-LAST:event_connectButtonActionPerformed

    private void showPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordButtonActionPerformed
        passwordField.setEchoChar(showPasswordButton.isSelected() ? '\u0000' : echoChar);
    }//GEN-LAST:event_showPasswordButtonActionPerformed

    private void userFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JPanel connectPanel;
    private javax.swing.JLabel connectingLabel;
    private javax.swing.JTextField databaseField;
    private javax.swing.JLabel databaseLabel;
    private javax.swing.JPanel databasePanel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JTextField serverField;
    private javax.swing.JLabel serverLabel;
    private javax.swing.JPanel serverPanel;
    private javax.swing.JCheckBox showPasswordButton;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
