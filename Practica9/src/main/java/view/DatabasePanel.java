package view;

import controller.DatabaseController;
import javax.swing.DefaultListModel;
import static javax.swing.ListSelectionModel.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DatabasePanel extends javax.swing.JPanel {

    DefaultListModel tablesModel = new DefaultListModel();
    DefaultListModel fieldsModel = new DefaultListModel();
    DatabaseController dbController;
    
    public DatabasePanel(DatabaseController dbController) {
        initComponents();
        this.dbController = dbController;
        for (String table : dbController.getTables()) {
            tablesModel.addElement(table);
        }
        tablesList.setModel(tablesModel);
        fieldsList.setModel(fieldsModel);
        
        tablesList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                fieldsModel.clear();
                for (String table : tablesList.getSelectedValuesList()) {
                    for (String field : dbController.getFields(table)) {
                        fieldsModel.addElement(field);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectionButtonGroup = new javax.swing.ButtonGroup();
        listsPanel = new javax.swing.JPanel();
        tablesPanel = new javax.swing.JScrollPane();
        tablesList = new javax.swing.JList<>();
        fieldsPanel = new javax.swing.JScrollPane();
        fieldsList = new javax.swing.JList<>();
        selectionPanel = new javax.swing.JPanel();
        selectionLabel = new javax.swing.JLabel();
        selectionButtonsPanel = new javax.swing.JPanel();
        singleButton = new javax.swing.JToggleButton();
        singleIntervalButton = new javax.swing.JToggleButton();
        multipleIntervalButton = new javax.swing.JToggleButton();

        setPreferredSize(new java.awt.Dimension(100000, 1000000));
        setLayout(new java.awt.GridLayout(2, 2, 15, 15));

        listsPanel.setLayout(new javax.swing.BoxLayout(listsPanel, javax.swing.BoxLayout.LINE_AXIS));

        tablesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        tablesPanel.setViewportView(tablesList);

        listsPanel.add(tablesPanel);

        fieldsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        fieldsPanel.setViewportView(fieldsList);

        listsPanel.add(fieldsPanel);

        add(listsPanel);

        selectionPanel.setLayout(new javax.swing.BoxLayout(selectionPanel, javax.swing.BoxLayout.PAGE_AXIS));

        selectionLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectionLabel.setText("Modo de selección");
        selectionLabel.setAlignmentX(0.5F);
        selectionPanel.add(selectionLabel);

        selectionButtonGroup.add(singleButton);
        singleButton.setText("Simple");
        singleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        singleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleButtonActionPerformed(evt);
            }
        });
        selectionButtonsPanel.add(singleButton);

        selectionButtonGroup.add(singleIntervalButton);
        singleIntervalButton.setText("Por intervalo");
        singleIntervalButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        singleIntervalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleIntervalButtonActionPerformed(evt);
            }
        });
        selectionButtonsPanel.add(singleIntervalButton);

        selectionButtonGroup.add(multipleIntervalButton);
        multipleIntervalButton.setText("Múltiples intervalos");
        multipleIntervalButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        multipleIntervalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multipleIntervalButtonActionPerformed(evt);
            }
        });
        selectionButtonsPanel.add(multipleIntervalButton);

        selectionPanel.add(selectionButtonsPanel);

        add(selectionPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void singleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleButtonActionPerformed
        fieldsList.setSelectionMode(SINGLE_SELECTION);
        tablesList.setSelectionMode(SINGLE_SELECTION);
    }//GEN-LAST:event_singleButtonActionPerformed

    private void singleIntervalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleIntervalButtonActionPerformed
        fieldsList.setSelectionMode(SINGLE_INTERVAL_SELECTION);
        tablesList.setSelectionMode(SINGLE_INTERVAL_SELECTION);
    }//GEN-LAST:event_singleIntervalButtonActionPerformed

    private void multipleIntervalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multipleIntervalButtonActionPerformed
        fieldsList.setSelectionMode(MULTIPLE_INTERVAL_SELECTION);
        tablesList.setSelectionMode(MULTIPLE_INTERVAL_SELECTION);
    }//GEN-LAST:event_multipleIntervalButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> fieldsList;
    private javax.swing.JScrollPane fieldsPanel;
    private javax.swing.JPanel listsPanel;
    private javax.swing.JToggleButton multipleIntervalButton;
    private javax.swing.ButtonGroup selectionButtonGroup;
    private javax.swing.JPanel selectionButtonsPanel;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.JPanel selectionPanel;
    private javax.swing.JToggleButton singleButton;
    private javax.swing.JToggleButton singleIntervalButton;
    private javax.swing.JList<String> tablesList;
    private javax.swing.JScrollPane tablesPanel;
    // End of variables declaration//GEN-END:variables
}
