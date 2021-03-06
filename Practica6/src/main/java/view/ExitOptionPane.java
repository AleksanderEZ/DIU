package view;

import javax.swing.JOptionPane;

public class ExitOptionPane extends JOptionPane {

    String ObjButtons[] = {"Guardar y salir", "Salir sin guardar", "Volver a la aplicación"};
    
    public int showOptionDialog(Display display) {
        int promptResult = JOptionPane.showOptionDialog(display, "¿Quieres guardar antes de salir?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, ObjButtons, ObjButtons[0]);
        return promptResult;
    }
}
