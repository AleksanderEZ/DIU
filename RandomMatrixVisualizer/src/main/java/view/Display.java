package view;

import Controller.MatrixModel;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Display extends javax.swing.JFrame {
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        configPanel = new javax.swing.JPanel();
        sliderPanel = new javax.swing.JPanel();
        minimumShownValue = new javax.swing.JSlider();
        rangeInputPanel = new javax.swing.JPanel();
        maxValuePanel = new javax.swing.JPanel();
        maxValueLabel = new javax.swing.JLabel();
        maxValueInput = new javax.swing.JTextField();
        minValuePanel = new javax.swing.JPanel();
        minValueLabel = new javax.swing.JLabel();
        minValueInput = new javax.swing.JTextField();
        errorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(870, 340));
        setName("Matriz aleatoria"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
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

        maxValuePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 15, 25, 15));
        maxValuePanel.setLayout(new javax.swing.BoxLayout(maxValuePanel, javax.swing.BoxLayout.PAGE_AXIS));

        maxValueLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        maxValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        maxValueLabel.setText("Valor máximo");
        maxValueLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        maxValuePanel.add(maxValueLabel);

        maxValueInput.setBorder(null);
        maxValuePanel.add(maxValueInput);

        rangeInputPanel.add(maxValuePanel);

        minValuePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 15, 25, 15));
        minValuePanel.setLayout(new javax.swing.BoxLayout(minValuePanel, javax.swing.BoxLayout.PAGE_AXIS));

        minValueLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        minValueLabel.setText("Valor mínimo");
        minValueLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        minValuePanel.add(minValueLabel);

        minValueInput.setBorder(null);
        minValuePanel.add(minValueInput);

        rangeInputPanel.add(minValuePanel);

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
    private javax.swing.JTextField maxValueInput;
    private javax.swing.JLabel maxValueLabel;
    private javax.swing.JPanel maxValuePanel;
    private javax.swing.JTextField minValueInput;
    private javax.swing.JLabel minValueLabel;
    private javax.swing.JPanel minValuePanel;
    private javax.swing.JSlider minimumShownValue;
    private javax.swing.JPanel rangeInputPanel;
    private javax.swing.JPanel sliderPanel;
    // End of variables declaration//GEN-END:variables
    private MatrixPanel matrixPanel;
    private final MatrixModel modelator = new MatrixModel();;
    private DocumentListener maxDL, minDL;
    private String maxText, minText;
    
    public Display() {
        setLookAndFeel();
        initComponents();
        
        maxText = "";
        minText = "";
        initDocumentListeners();
        
        initMatrixModel();
        
        setMatrixPanel();
        setTitle("Random Matrix Viewer");
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initMatrixModel() {
        modelator.setMaxMatrixValue(minimumShownValue.getMaximum());
        modelator.setMinMatrixValue(minimumShownValue.getMinimum());
        modelator.generate();
    }
    
    private void initDocumentListeners() {
        maxDL = getRangeMaximumInputDocumentListener();
        minDL = getRangeMinimumInputDocumentListener();
        maxValueInput.getDocument().addDocumentListener(maxDL);
        minValueInput.getDocument().addDocumentListener(minDL);
    }

    private DocumentListener getRangeMinimumInputDocumentListener() {
        return new DocumentListener() {
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
                    if(minText.equals("") && minValueInput.getText().equals("-")){
                        
                    } else {
                        resetText(minValueInput, minDL, minText);
                        errorMessage.setVisible(true);
                    }
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
    }

    private DocumentListener getRangeMaximumInputDocumentListener() {
        return new DocumentListener() {
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
                    if(maxText.equals("") && maxValueInput.getText().equals("-")){
                        
                    } else {
                        resetText(maxValueInput, maxDL, maxText);
                        errorMessage.setVisible(true);
                    }
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
    }
    
    private void reloadMatrix() {
        modelator.setMaxMatrixValue(minimumShownValue.getMaximum());
        modelator.setMinMatrixValue(minimumShownValue.getMinimum());
        modelator.generate();
        setMatrixPanel();
    }
    
    private void setMatrixPanel() {
        matrixPanel = modelator.getMatrixPanel(minimumShownValue.getValue());
        updateFrame();
    }

    private void updateFrame() {
        getContentPane().removeAll();
        getContentPane().add(matrixPanel);
        getContentPane().add(configPanel);
        this.validate();
        this.repaint();
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
    
    public void run() {
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(false);
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
    
}
