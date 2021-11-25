/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 *
 * @author ALE-K
 */
public class ProgressDialog extends JDialog{
    
    JProgressBar progressBar;

    public ProgressDialog(JFrame frame) {
        super(frame, "En progreso");
        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setString("Por favor espere...");
        progressBar.setStringPainted(true);
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }
    
}
