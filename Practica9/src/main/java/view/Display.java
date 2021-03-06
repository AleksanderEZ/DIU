package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import controller.DatabaseController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Display extends javax.swing.JFrame {

    private JPanel databasePanel;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new view.LoginPanel(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Explorador de bases de datos");
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));
        getContentPane().add(loginPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Display() {
        setLookAndFeel();
        initComponents();
        
        run();
    }
    
    public void setDatabasePanel(DatabaseController databaseController) {
        databasePanel = new DatabasePanel(this, databaseController);
        setContentPane(databasePanel);
        revalidate();
        repaint();
    }
    
    public void setLoginPanel() {
        setContentPane(loginPanel);
        revalidate();
        repaint();
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
    private view.LoginPanel loginPanel;
    // End of variables declaration//GEN-END:variables
}
