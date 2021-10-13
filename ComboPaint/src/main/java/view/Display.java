package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.Color;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ALE-K and Lucas
 */
public class Display extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backgroundLabel = new javax.swing.JLabel();
        backgroundBox = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(100, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        foregroundLabel = new javax.swing.JLabel();
        foregroundBox = new javax.swing.JComboBox<>();
        canvas = new view.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint!");

        backgroundLabel.setText("Fondo");
        jPanel1.add(backgroundLabel);

        javax.swing.DefaultComboBoxModel<String> modelBackground = new javax.swing.DefaultComboBoxModel<>();
        modelBackground.addAll(colorMap.keySet());
        backgroundBox.setModel(modelBackground);
        backgroundBox.setSelectedIndex(3);
        backgroundBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundBoxActionPerformed(evt);
            }
        });
        jPanel1.add(backgroundBox);

        filler1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(filler1);

        foregroundLabel.setText("Puntero");
        jPanel1.add(foregroundLabel);

        javax.swing.DefaultComboBoxModel<String> modelForeground = new javax.swing.DefaultComboBoxModel<>();
        modelForeground.addAll(colorMap.keySet());
        foregroundBox.setModel(modelForeground);
        foregroundBox.setSelectedItem("Negro");
        foregroundBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foregroundBoxActionPerformed(evt);
            }
        });
        jPanel1.add(foregroundBox);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        canvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvasMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                canvasMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        getContentPane().add(canvas, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    HashMap<String, Color> colorMap = new HashMap<>();
    String[] colorNames = {"Blanco", "Negro", "Azul", "Rojo", "Verde", "Amarillo"};
    Color[] colorValues = {Color.white, Color.black, Color.blue, Color.red, Color.green, Color.yellow};
    
    private void canvasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseMoved
        canvas.setMousePosition(evt.getX(), evt.getY());
        canvas.repaint();
    }//GEN-LAST:event_canvasMouseMoved

    private void backgroundBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backgroundBoxActionPerformed
        canvas.setBackgroundColor(colorMap.get(backgroundBox.getSelectedItem()));
    }//GEN-LAST:event_backgroundBoxActionPerformed

    private void foregroundBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foregroundBoxActionPerformed
        canvas.setForegroundColor(colorMap.get(foregroundBox.getSelectedItem()));
    }//GEN-LAST:event_foregroundBoxActionPerformed

    private void canvasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseDragged
        canvas.setMousePosition(evt.getX(), evt.getY());
        canvas.repaint();
    }//GEN-LAST:event_canvasMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> backgroundBox;
    private javax.swing.JLabel backgroundLabel;
    private view.Canvas canvas;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JComboBox<String> foregroundBox;
    private javax.swing.JLabel foregroundLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    public Display() {
        initHashmap();
        setLookAndFeel();
        initComponents();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initHashmap() {
        for (int i = 0; i < colorNames.length; i++) {
            colorMap.put(colorNames[i], colorValues[i]);
        }
    }
}
