package view;

import control.ImageFileSaver;
import com.formdev.flatlaf.FlatDarculaLaf;
import control.DesktopFile;
import control.Thresholder;
import control.FileImageLoader;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Display extends javax.swing.JFrame {

    private final FileImageLoader loader = new FileImageLoader();
    private boolean saved = true;
    private BufferedImage loadedImage;
    BufferedImage lastThresholdedImage;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPanel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        threshold = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 320));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout desktopPanelLayout = new javax.swing.GroupLayout(desktopPanel);
        desktopPanel.setLayout(desktopPanelLayout);
        desktopPanelLayout.setHorizontalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );
        desktopPanelLayout.setVerticalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        getContentPane().add(desktopPanel);
        desktopPanel.setVisible(true);

        file.setText("Archivo");

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        open.setText("Abrir");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        file.add(open);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        save.setText("Guardar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        file.add(save);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        file.add(exit);

        jMenuBar1.add(file);

        edit.setText("Editar");

        threshold.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        threshold.setText("Umbral");
        threshold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdActionPerformed(evt);
            }
        });
        edit.add(threshold);

        jMenuBar1.add(edit);

        help.setText("Ayuda");

        about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        about.setText("Acerca de");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File imageFile = fileChooser.getSelectedFile();
            loadedImage = loader.load(imageFile);
            //desktopPanel.removeAll();
            desktopPanel.repaint();
            desktopPanel.revalidate();
            ImagePanel.resetFrameCount();
            ImagePanel imagePanel = new ImagePanel(imageFile.getName());
            desktopPanel.add(imagePanel);
            imagePanel.setImage(loadedImage);
            setSize(imagePanel.getWidth() + 16, imagePanel.getHeight() + 62);
            saved = true;
            try {
                imagePanel.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {};
        }
    }//GEN-LAST:event_openActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        openSaveDialog();
    }//GEN-LAST:event_saveActionPerformed

    private void openSaveDialog() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            ImageFileSaver fileSaver = new ImageFileSaver(fileChooser.getSelectedFile(), lastThresholdedImage);
            fileSaver.save();
            saved = true;
        } else {
            Logger.getLogger(Display.class.getName()).log(Level.INFO, "Guardar cancelado");
        }
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        openExitDialog();
    }//GEN-LAST:event_exitActionPerformed

    private void openExitDialog() {
        int promptResult = new ExitOptionPane().showOptionDialog(this);
        switch (promptResult) {
            case ExitOptionPane.YES_OPTION:
                openSaveDialogAndExit();
                break;
            case ExitOptionPane.NO_OPTION:
                System.exit(0);
            case ExitOptionPane.CANCEL_OPTION:
                break;
            default:
                break;
        }
    }

    private void openSaveDialogAndExit() {
        openSaveDialog();
        System.exit(0);
    }

    private void applyThresholdToCurrentImage() {
        ThresholdDialog dialog = new ThresholdDialog();
        Integer promptThreshold = dialog.showInputDialog(this);
        if (promptThreshold != null && loadedImage != null) {
            ImagePanel imagePanel = new ImagePanel("Umbralizado de valor " + promptThreshold.toString());
            desktopPanel.add(imagePanel);
            
            lastThresholdedImage = Thresholder.applyThreshold(loadedImage, promptThreshold);
            imagePanel.setImage(lastThresholdedImage);
            try {
                imagePanel.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {};
        }
    }

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        openAboutDialog();
    }//GEN-LAST:event_aboutActionPerformed

    private void thresholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdActionPerformed
        applyThresholdToCurrentImage();
        saved = false;
    }//GEN-LAST:event_thresholdActionPerformed

    private void openAboutDialog() {
        new AboutDialog(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JDesktopPane desktopPanel;
    private javax.swing.JMenu edit;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu file;
    private javax.swing.JMenu help;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem threshold;
    // End of variables declaration//GEN-END:variables
    private final JFileChooser fileChooser = new JFileChooser(new DesktopFile());

    public void run() {
        setVisible(true);
    }

    public Display() {
        setLookAndFeel();
        initComponents();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Todas las imágenes", "jpg", "jpeg", "png", "gif", "bmp", "wbmp") );
        setTitle("Editor de imágenes");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        askBeforeClosingOperation();
        loadThresholdingLibrary();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void askBeforeClosingOperation() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (!saved && desktopPanel.getAllFrames().length > 0) {
                    openExitDialog();
                } else {
                    System.exit(0);
                }
            }
        });
    }

    private void loadThresholdingLibrary() {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
    }
}
