package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressDialog extends JDialog {

    Display window;
    
    public ProgressDialog(JFrame parent) {
        super(parent);
        this.window = (Display) parent;
        initComponents();
    }
    
    public JProgressBar getProgressBar() {
        return progressBar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        cancelButtonPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Progreso");
        setMinimumSize(new java.awt.Dimension(320, 100));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        progressBar.setString("Por favor, espere...");
        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);

        cancelButtonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        cancelButtonPanel.add(cancelButton);

        getContentPane().add(cancelButtonPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        window.cancelOperation();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel cancelButtonPanel;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
