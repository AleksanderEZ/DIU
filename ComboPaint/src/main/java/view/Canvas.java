package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    public void Canvas() {
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.blue);
        Point mousePosition = MouseInfo.getPointerInfo().getLocation();
        g.drawOval(mousePosition.x, mousePosition.y, 10, 10);
    }
}
