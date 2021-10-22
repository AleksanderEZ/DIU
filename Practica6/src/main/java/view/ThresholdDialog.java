package view;

import javax.swing.JOptionPane;

public class ThresholdDialog extends JOptionPane {

    private final String title;
    private final String text;
    private final int textType;
    String[] optionsArray;
    String defaultOption;

    public ThresholdDialog() {
        this.optionsArray = new String[]{"Aceptar", "Cancelar"};
        this.defaultOption = optionsArray[0];
        this.title = "Umbral";
        this.textType = QUESTION_MESSAGE;
        this.text = "Introduzca el umbral";
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
