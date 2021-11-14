package view;

public class LoginPanel extends javax.swing.JPanel {

    public LoginPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        loginPanel = new javax.swing.JPanel();
        connectionPanel = new javax.swing.JPanel();
        connectionLabel = new javax.swing.JLabel();
        connectionField = new javax.swing.JTextField();
        userPanel = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passwordPanel = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        connectButton = new javax.swing.JButton();

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

        connectionPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        connectionLabel.setText("URL de conexión: ");
        connectionPanel.add(connectionLabel);

        connectionField.setColumns(30);
        connectionField.setText(" mozart.dis.ulpgc.es/DIU_BD?useSSL=true");
        connectionPanel.add(connectionField);

        loginPanel.add(connectionPanel);

        userPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        userLabel.setText("Usuario: ");
        userPanel.add(userLabel);

        userField.setColumns(30);
        userField.setText("estudiante-DIU");
        userPanel.add(userField);

        loginPanel.add(userPanel);

        passwordPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        passwordLabel.setText("Contraseña: ");
        passwordPanel.add(passwordLabel);

        passwordField.setText("Clave prácticas");
        passwordPanel.add(passwordField);

        loginPanel.add(passwordPanel);

        connectButton.setText("Conectar");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        loginPanel.add(connectButton);

        add(loginPanel, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // Conectar con la base de datos. 
        // Si conecta, cambiar este JPanel por el JPanel de mostrar datos, repaint, revalidate
    }//GEN-LAST:event_connectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JTextField connectionField;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JPanel connectionPanel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
