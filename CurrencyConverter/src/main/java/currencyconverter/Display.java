package currencyconverter;

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

        euroInput = new javax.swing.JTextField();
        dollarInput = new javax.swing.JTextField();
        euroLabel = new javax.swing.JLabel();
        dollarLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(240, 180));
        setMinimumSize(new java.awt.Dimension(240, 180));
        setPreferredSize(new java.awt.Dimension(240, 180));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(euroInput, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(euroLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dollarInput, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dollarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(41, Short.MAX_VALUE))
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
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void euroInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_euroInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_euroInputActionPerformed

    private void dollarInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dollarInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dollarInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dollarInput;
    private javax.swing.JLabel dollarLabel;
    private javax.swing.JTextField euroInput;
    private javax.swing.JLabel euroLabel;
    // End of variables declaration//GEN-END:variables
}
