package view;

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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        fileChooser = new javax.swing.JFileChooser();
        buttonChooserPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        compressButtonPanel = new javax.swing.JPanel();
        compressButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(fileChooser);

        jPanel3.add(jPanel1);

        buttonChooserPanel.setLayout(new javax.swing.BoxLayout(buttonChooserPanel, javax.swing.BoxLayout.PAGE_AXIS));

        addButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addButton.setText("→");
        buttonChooserPanel.add(addButton);

        removeButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removeButton.setText("←");
        buttonChooserPanel.add(removeButton);

        jPanel3.add(buttonChooserPanel);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Algo largo para probar la eficiencia", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3);

        compressButtonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        compressButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        compressButton.setText("¡Comprimir!");
        compressButtonPanel.add(compressButton);

        getContentPane().add(compressButtonPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel buttonChooserPanel;
    private javax.swing.JButton compressButton;
    private javax.swing.JPanel compressButtonPanel;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
