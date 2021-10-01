package view;

import javax.swing.BorderFactory;

public class MatrixCell extends javax.swing.JPanel {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cell = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        cell.setColumns(20);
        cell.setRows(5);
        add(cell);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea cell;
    // End of variables declaration//GEN-END:variables

    public MatrixCell(String matrixValue) {
        initComponents();
        cell.setText(matrixValue);
        cell.setEditable(false);
        cell.setSize(50, 50);
        cell.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }
}
