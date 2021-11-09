package view;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutDialog extends JDialog {
    
    JPanel infoPanel = new JPanel();
    JLabel names = new JLabel("Aleksander y Lucas", SwingConstants.CENTER);
    JLabel practica = new JLabel("Práctica 6 - Diseño de Interfaces de Usuario", SwingConstants.CENTER);
    JLabel bestWishes = new JLabel("Esperamos que les guste 😊", SwingConstants.CENTER);
    
    public AboutDialog(JFrame mainWindow) {
        super(mainWindow, "Acerca de la aplicación");
        
        getContentPane().setLayout(new BorderLayout());
        BoxLayout panelLayout = new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS);
        infoPanel.setLayout(panelLayout);
        infoPanel.add(names);
        infoPanel.add(practica);
        infoPanel.add(bestWishes);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        getContentPane().add(infoPanel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(mainWindow);
        setVisible(true);
    }
}
