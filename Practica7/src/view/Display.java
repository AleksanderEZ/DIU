package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import controller.FileImageLoader;
import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Display extends javax.swing.JFrame {
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        redComponent = new javax.swing.JTextField();
        greenComponent = new javax.swing.JTextField();
        blueComponent = new javax.swing.JTextField();
        openPanel = new javax.swing.JPanel();
        openButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image color analyzer");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("mainFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        setType(java.awt.Window.Type.UTILITY);

        redComponent.setBackground(new java.awt.Color(255, 153, 153));
        redComponent.setColumns(41);
        redComponent.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        redComponent.setText("MAX:         MEDIA:         MIN:");
        redComponent.setToolTipText("Valor de rojo MAX;MEDIO;MIN");
        redComponent.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        redComponent.setEnabled(false);
        upperPanel.add(redComponent);

        greenComponent.setBackground(new java.awt.Color(153, 255, 153));
        greenComponent.setColumns(41);
        greenComponent.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        greenComponent.setText("MAX:         MEDIA:         MIN:");
        greenComponent.setToolTipText("Valor de verde MAX;MEDIO;MIN");
        greenComponent.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        greenComponent.setEnabled(false);
        upperPanel.add(greenComponent);

        blueComponent.setBackground(new java.awt.Color(153, 153, 255));
        blueComponent.setColumns(41);
        blueComponent.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        blueComponent.setText("MAX:         MEDIA:         MIN:");
        blueComponent.setToolTipText("Valor de azul MAX;MEDIO;MIN");
        blueComponent.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        blueComponent.setEnabled(false);
        upperPanel.add(blueComponent);

        openPanel.setMaximumSize(new java.awt.Dimension(30, 30));
        openPanel.setMinimumSize(new java.awt.Dimension(30, 30));
        openPanel.setPreferredSize(new java.awt.Dimension(32, 30));
        openPanel.setLayout(new java.awt.BorderLayout());

        openButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/open.png"))); // NOI18N
        openButton.setBorderPainted(false);
        openButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        openButton.setOpaque(false);
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        openPanel.add(openButton, java.awt.BorderLayout.CENTER);

        upperPanel.add(openPanel);

        getContentPane().add(upperPanel, java.awt.BorderLayout.NORTH);

        bottomPanel.setLayout(new java.awt.BorderLayout());
        bottomPanel.add(scrollPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    FileImageLoader fileImageLoader = new FileImageLoader();
    
    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            displayImage(fileImageLoader.load(file));
        }
    }//GEN-LAST:event_openButtonActionPerformed
    
    private void displayImage(BufferedImage bufferedImage) {
        JLabel image = new JLabel(new ImageIcon(bufferedImage));
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(image);
        scrollPane.getViewport().setView(panel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField blueComponent;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JTextField greenComponent;
    private javax.swing.JButton openButton;
    private javax.swing.JPanel openPanel;
    private javax.swing.JTextField redComponent;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables
    
    private final JFileChooser fileChooser = new JFileChooser();
    private final String smileyPath = "assets/smiley.png";
    
    public Display() {
        setLookAndFeel();
        initComponents();
        initOpenCV();
        scrollPaneListeners();
    }

    public void run(){
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initOpenCV() {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }
    
    private void scrollPaneListeners() {
        scrollPane.getVerticalScrollBar().addAdjustmentListener(getAdjustmentListener());
        scrollPane.getHorizontalScrollBar().addAdjustmentListener(getAdjustmentListener());
    }
    
    private AdjustmentListener getAdjustmentListener() {
        return new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                updateColorFields();
            }
        };
    }
    
    private void updateColorFields() {
        // LUCAS STUFF
    }
}
