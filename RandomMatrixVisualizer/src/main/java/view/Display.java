package view;

import Controller.MatrixModelator;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Display extends javax.swing.JFrame {

    MatrixPanel matrixPanel;
    MatrixModelator modelator;
    DocumentListener maxDL, minDL;
    String maxText, minText;
    
    public Display() {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        initComponents();
        maxText = "";
        minText = "";
        addDocumentListeners();
        modelator = new MatrixModelator();
        modelator.setMaxMatrixValue(minimumShownValue.getMaximum());
        modelator.setMinMatrixValue(minimumShownValue.getMinimum());
        modelator.generate();
        setMatrixPanel();
        setTitle("Random Matrix Viewer");
    }
    
    private void reloadMatrix() {
        modelator.setMaxMatrixValue(minimumShownValue.getMaximum());
        modelator.setMinMatrixValue(minimumShownValue.getMinimum());
        modelator.generate();
        setMatrixPanel();
    }

    public void run() {
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(false);
    }
    
    private void resetText(JTextField field, DocumentListener listener, String text) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                field.getDocument().removeDocumentListener(listener);
                field.setText(text);
                field.getDocument().addDocumentListener(listener);
            }
        });
    }
    
    private void addDocumentListeners() {
        maxDL = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    int maxValue = Integer.parseInt(maxValueInput.getText());
                    if (maxValue > minimumShownValue.getMinimum()) {
                        minimumShownValue.setMaximum(maxValue);
                        Display.this.setLabels(minimumShownValue, 10);
                        reloadMatrix();
                        errorMessage.setVisible(false);
                    }
                    maxText = maxValueInput.getText();
                } catch (NumberFormatException exception) {
                    resetText(maxValueInput, maxDL, maxText);
                    errorMessage.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    int maxValue = Integer.parseInt(maxValueInput.getText());
                    if (maxValue > minimumShownValue.getMinimum()) {
                        minimumShownValue.setMaximum(maxValue);
                        Display.this.setLabels(minimumShownValue, 10);
                        reloadMatrix();
                        errorMessage.setVisible(false);
                    }
                    maxText = maxValueInput.getText();
                } catch (NumberFormatException exception) {
                    if (!maxValueInput.getText().equals("")) {
                        resetText(maxValueInput, maxDL, maxText);
                        errorMessage.setVisible(true);
                    }
                    else {
                        maxText = "";
                        errorMessage.setVisible(false);
                    }
                    
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        };
        minDL = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    int minValue = Integer.parseInt(minValueInput.getText());
                    if (minValue < minimumShownValue.getMaximum()) {
                        minimumShownValue.setMinimum(minValue);
                        Display.this.setLabels(minimumShownValue, 10);
                        reloadMatrix();
                        errorMessage.setVisible(false);
                    }
                } catch (NumberFormatException exception) {
                    resetText(minValueInput, minDL, minText);
                    errorMessage.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    int minValue = Integer.parseInt(minValueInput.getText());
                    if (minValue < minimumShownValue.getMaximum()) {
                        minimumShownValue.setMinimum(minValue);
                        Display.this.setLabels(minimumShownValue, 10);
                        reloadMatrix();
                        errorMessage.setVisible(false);
                    }
                } catch (NumberFormatException exception) {
                    if (!minValueInput.getText().equals("")) {
                        resetText(minValueInput, minDL, minText);
                        errorMessage.setVisible(true);
                    } else {
                        minText = "";
                        errorMessage.setVisible(false);
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        };
        maxValueInput.getDocument().addDocumentListener(maxDL);
        minValueInput.getDocument().addDocumentListener(minDL);
    }
    
    private void setLabels(JSlider slider, int step) {
        double max = slider.getMaximum();
        double min = slider.getMinimum();
        double range = (max - min)/step;
        slider.setMajorTickSpacing((int) range);
        Hashtable<Integer, JLabel> table = new Hashtable<>();
        Integer prev = null;
        for (double i = min, j = 0; i <= max; i += range, j++) {
            Integer current = (int) i;
            if (!current.equals(prev)) {
                table.put(current, new JLabel(current.toString()));
            }
        }
        slider.setLabelTable(table);
    }
    
    private void setMatrixPanel() {
        matrixPanel = modelator.getMatrixPanel(minimumShownValue.getValue());
        getContentPane().removeAll();
        getContentPane().add(matrixPanel);
        getContentPane().add(configPanel);
        this.validate();
        this.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        configPanel = new javax.swing.JPanel();
        sliderPanel = new javax.swing.JPanel();
        minimumShownValue = new javax.swing.JSlider();
        rangeInputPanel = new javax.swing.JPanel();
        maxValue = new javax.swing.JPanel();
        maxValueLabel = new javax.swing.JLabel();
        maxValueInput = new javax.swing.JTextField();
        minValue = new javax.swing.JPanel();
        minValueLabel = new javax.swing.JLabel();
        minValueInput = new javax.swing.JTextField();
        errorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Matriz aleatoria"); // NOI18N
        setPreferredSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        configPanel.setLayout(new java.awt.BorderLayout());

        sliderPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sliderPanel.setLayout(new javax.swing.BoxLayout(sliderPanel, javax.swing.BoxLayout.PAGE_AXIS));

        minimumShownValue.setMajorTickSpacing(10);
        minimumShownValue.setOrientation(javax.swing.JSlider.VERTICAL);
        minimumShownValue.setPaintLabels(true);
        minimumShownValue.setPaintTicks(true);
        minimumShownValue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minimumShownValueStateChanged(evt);
            }
        });
        sliderPanel.add(minimumShownValue);

        configPanel.add(sliderPanel, java.awt.BorderLayout.CENTER);

        rangeInputPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rangeInputPanel.setLayout(new javax.swing.BoxLayout(rangeInputPanel, javax.swing.BoxLayout.PAGE_AXIS));

        maxValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 15, 25, 15));
        maxValue.setLayout(new javax.swing.BoxLayout(maxValue, javax.swing.BoxLayout.PAGE_AXIS));

        maxValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        maxValueLabel.setText("Valor máximo");
        maxValueLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        maxValue.add(maxValueLabel);

        maxValueInput.setBorder(null);
        maxValue.add(maxValueInput);

        rangeInputPanel.add(maxValue);

        minValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 15, 25, 15));
        minValue.setLayout(new javax.swing.BoxLayout(minValue, javax.swing.BoxLayout.PAGE_AXIS));

        minValueLabel.setText("Valor mínimo");
        minValueLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        minValue.add(minValueLabel);

        minValueInput.setBorder(null);
        minValue.add(minValueInput);

        rangeInputPanel.add(minValue);

        errorMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 0, 0));
        errorMessage.setText("Solo números sin coma");
        rangeInputPanel.add(errorMessage);
        errorMessage.setVisible(false);

        configPanel.add(rangeInputPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(configPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimumShownValueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minimumShownValueStateChanged
        setMatrixPanel();
        System.out.println(minimumShownValue.getValue());
    }//GEN-LAST:event_minimumShownValueStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel configPanel;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JPanel maxValue;
    private javax.swing.JTextField maxValueInput;
    private javax.swing.JLabel maxValueLabel;
    private javax.swing.JPanel minValue;
    private javax.swing.JTextField minValueInput;
    private javax.swing.JLabel minValueLabel;
    private javax.swing.JSlider minimumShownValue;
    private javax.swing.JPanel rangeInputPanel;
    private javax.swing.JPanel sliderPanel;
    // End of variables declaration//GEN-END:variables

}
