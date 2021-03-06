package view;

import control.ImageFileSaver;
import com.formdev.flatlaf.FlatDarculaLaf;
import control.DesktopFile;
import control.Thresholder;
import control.FileImageLoader;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = new view.ImagePanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        threshold = new javax.swing.JMenuItem();
        undo = new javax.swing.JMenuItem();
        redo = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 320));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(imagePanel);
        imagePanel.setBounds(0, 0, 506, 279);

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

        undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        undo.setText("Deshacer");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });
        edit.add(undo);

        redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        redo.setText("Rehacer");
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });
        edit.add(redo);

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
            loadedImage = loader.load(fileChooser.getSelectedFile());
            imagePanel.setImage(loadedImage);
            setSize(imagePanel.getWidth() + 16, imagePanel.getHeight() + 62);
        }
    }//GEN-LAST:event_openActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        openSaveDialog();
    }//GEN-LAST:event_saveActionPerformed

    private void openSaveDialog() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            ImageFileSaver fileSaver = new ImageFileSaver(fileChooser.getSelectedFile(), imagePanel.getImage());
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
        if (promptResult == ExitOptionPane.YES_OPTION) {
            openSaveDialogAndExit();
        } else if (promptResult == ExitOptionPane.NO_OPTION) {
            System.exit(0);
        } else if (promptResult == ExitOptionPane.CANCEL_OPTION) {
        }
    }

    private void openSaveDialogAndExit() {
        openSaveDialog();
        System.exit(0);
    }

    private void thresholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdActionPerformed
        applyThresholdToCurrentImage();
        saved = false;
    }//GEN-LAST:event_thresholdActionPerformed

    private void applyThresholdToCurrentImage() {
        ThresholdDialog dialog = new ThresholdDialog();
        Integer promptThreshold = dialog.showInputDialog(this);
        if (promptThreshold != null && loadedImage != null) {
            imagePanel.setImage(Thresholder.applyThreshold(loadedImage, promptThreshold));
        }
    }

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        openAboutDialog();
    }//GEN-LAST:event_aboutActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        imagePanel.setNextImage();
    }//GEN-LAST:event_redoActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        imagePanel.setPreviousImage();
    }//GEN-LAST:event_undoActionPerformed

    private void openAboutDialog() {
        new AboutDialog(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenu edit;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu file;
    private javax.swing.JMenu help;
    private view.ImagePanel imagePanel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem redo;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem threshold;
    private javax.swing.JMenuItem undo;
    // End of variables declaration//GEN-END:variables
    private final JFileChooser fileChooser = new JFileChooser(new DesktopFile());

    public void run() {
        setVisible(true);
    }

    public Display() {
        setLookAndFeel();
        initComponents();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Todas las im??genes", "jpg", "jpeg", "png", "gif", "bmp", "wbmp") );
        setTitle("Editor de im??genes");
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
                if (!saved) {
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
