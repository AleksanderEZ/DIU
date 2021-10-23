package view;

import javax.swing.JOptionPane;

public class ThresholdDialog extends JOptionPane {

    String[] optionsArray;
    String defaultOption;

    public ThresholdDialog() {
        this.optionsArray = new String[]{"Aceptar", "Cancelar"};
        this.defaultOption = optionsArray[0];
    }

    public Integer showInputDialog(Display frame) {
        String prompt = showInputDialog(frame, "Introduzca el umbral");
        
        if (!prompt.equals(null)) {
            Integer promptToInteger = null;
            try {
                promptToInteger = Integer.parseInt(prompt);
            } catch (NumberFormatException e) {
                promptToInteger = showInputDialogWrong(frame);
            }
            return promptToInteger;
        }
        return null;
    }

    private Integer showInputDialogWrong(Display frame) {
        String prompt = showInputDialog(frame, "Introduzca un número válido");
        
        if (!prompt.equals(null)) {
            Integer promptToInteger = null;
            try {
                promptToInteger = Integer.parseInt(prompt);
            } catch (NumberFormatException e) {
                showInputDialogWrong(frame);
            }
            return promptToInteger;
        }
        return null;
    }
}
