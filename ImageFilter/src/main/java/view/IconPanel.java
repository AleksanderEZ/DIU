package view;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconPanel extends JPanel {

    JLabel icon;
    JPanel panelHolder[] = new JPanel[4];
    int position;

    public IconPanel() {
        setLayout(new GridLayout(2, 2));
        this.icon = new JLabel();
        setOpaque(false);
    }
    
    public void setImage(BufferedImage image){
        remove(icon);
        icon = new JLabel(new ImageIcon(image));
        resetPanels();
    }
    
    public void setPosition(int position){
        this.position = position;
        resetPanels();
    }
    
    private void resetPanels(){
        removeAll();
        for (int i = 0; i < panelHolder.length; i++) {
            panelHolder[i] = new JPanel();
            if(i == position){
                panelHolder[i].add(icon);
            }
            add(panelHolder[i]);
        }
        updatePanel();
    }
    
    public void updatePanel() {
        revalidate();
        repaint();
    }
}
