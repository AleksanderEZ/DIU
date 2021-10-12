package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    
    private final Point mousePosition = new Point(-1, -1);
    private Point[] positions = new Point[5];
    private final int diameter = 10;
    private Color backgroundColor = Color.white;
    private Color foregroundColor = Color.black;
    
    public void Canvas() {
        
    }
    
    public void setMousePosition(int x, int y) {
        mousePosition.x = x;
        mousePosition.y = y;
    }
    
    public void setBackgroundColor(Color color) {
        backgroundColor = color;
        repaint();
    }
    
    public void setForegroundColor(Color color) {
        foregroundColor = color;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(backgroundColor);
        this.setForeground(foregroundColor);
        
        if (positions[0] != null) {
            Point[] copy = new Point[positions.length];
            for (int i = 0; i < positions.length; i++) {
                copy[i] = (Point) positions[i].clone();
            }
            for (int i = 1; i < positions.length; i++) {
                positions[i] = copy[i-1];
            }
            positions[0] = mousePosition;

            for (Point position : positions) {
                g.fillOval(position.x - diameter/2, position.y - diameter/2, diameter, diameter);
            }
        } else {
            for (int i = 0; i < positions.length; i++) {
                positions[i] = new Point(-100, -100);
            }
        }
    }
}
