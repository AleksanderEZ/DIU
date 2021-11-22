package view;

import control.Zipper;
import java.io.File;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Display extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zipSettingsPanel = new javax.swing.JPanel();
        fileChooserPanel = new javax.swing.JPanel();
        fileChooser = new javax.swing.JFileChooser();
        chooserButtonsPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        filesListPanel = new javax.swing.JScrollPane();
        filesList = new javax.swing.JList<>();
        compressButtonPanel = new javax.swing.JPanel();
        compressButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zipper");
        setName("Zipper"); // NOI18N
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        zipSettingsPanel.setLayout(new javax.swing.BoxLayout(zipSettingsPanel, javax.swing.BoxLayout.LINE_AXIS));

        fileChooserPanel.setLayout(new javax.swing.BoxLayout(fileChooserPanel, javax.swing.BoxLayout.LINE_AXIS));

        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setControlButtonsAreShown(false);
        fileChooserPanel.add(fileChooser);

        zipSettingsPanel.add(fileChooserPanel);

        chooserButtonsPanel.setLayout(new javax.swing.BoxLayout(chooserButtonsPanel, javax.swing.BoxLayout.PAGE_AXIS));

        addButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addButton.setText("→");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        chooserButtonsPanel.add(addButton);

        removeButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removeButton.setText("←");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        chooserButtonsPanel.add(removeButton);

        zipSettingsPanel.add(chooserButtonsPanel);

        filesListPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        filesList.setModel(filesModel);
        filesListPanel.setViewportView(filesList);

        zipSettingsPanel.add(filesListPanel);

        getContentPane().add(zipSettingsPanel);

        compressButtonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        compressButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        compressButton.setText("¡Comprimir!");
        compressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressButtonActionPerformed(evt);
            }
        });
        compressButtonPanel.add(compressButton);

        getContentPane().add(compressButtonPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        File[] selectedFiles = fileChooser.getSelectedFiles();
        for (File file : selectedFiles) {
            String filename = file.getAbsolutePath();
            if (!filesModel.contains(filename)) {
                filesModel.addElement(filename);
            }
        }
        filesListPanel.revalidate();
        filesListPanel.repaint();
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        filesList.getSelectedValuesList().forEach(file -> {
            filesModel.removeElement(file);
        });
    }//GEN-LAST:event_removeButtonActionPerformed

    private void compressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compressButtonActionPerformed
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String selectedZipPath = "";
            try {
                selectedZipPath = saveFileChooser.getSelectedFile().getCanonicalPath();
            } catch (IOException ex) {
                System.out.println("Error in Display::compressButtonActionPerformed - " + ex.getMessage());
            }
            if (selectedZipPath.length() > 0) {
                Zipper zipper = new Zipper(BUFFER_SIZE);
                for (String file : getChosenFiles()) {
                    zipper.addFileToCompressionGroup(file);
                }
                zipper.zipFiles(selectedZipPath);
            }
        }
    }//GEN-LAST:event_compressButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel chooserButtonsPanel;
    private javax.swing.JButton compressButton;
    private javax.swing.JPanel compressButtonPanel;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JPanel fileChooserPanel;
    private javax.swing.JList<String> filesList;
    private javax.swing.JScrollPane filesListPanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JPanel zipSettingsPanel;
    // End of variables declaration//GEN-END:variables

    DefaultListModel<String> filesModel = new DefaultListModel<>();
    JFileChooser saveFileChooser = new JFileChooser();
    private final int BUFFER_SIZE = 1000;

    public Display() {
        setLookAndFeel();
        initComponents();
        saveFileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
    }

    public void run() {
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Error in Display::setLookAndFeel - " + e.getMessage());
        }
    }

    private Iterable<String> getChosenFiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
