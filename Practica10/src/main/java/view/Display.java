package view;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;

public class Display extends javax.swing.JFrame {

    DefaultListModel<String> filesModel = new DefaultListModel<>();
    
    public Display() {
        setLookAndFeel();
        initComponents();
    }
    
    public void run() {
        setVisible(true);
    }

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

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
           // handle exception
        }
    }
}
