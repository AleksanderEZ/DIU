package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    public void Canvas() {
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.red);
    }
}
