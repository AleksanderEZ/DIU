package view;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class iconPanel extends JPanel {
    
    JLabel icon;
    
    public iconPanel() {
        this.icon = new JLabel();
        add(icon);
        setLayout(new GridLayout(2, 2));
        setOpaque(false);
    }
    
    public void setImage(BufferedImage image){
        remove(icon);
        icon = new JLabel(new ImageIcon(image));
        add(icon);
    }
    
    public void update(){
        revalidate();
        repaint();
    }
}
