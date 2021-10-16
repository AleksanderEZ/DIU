package view;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconPanel extends JPanel {

    JLabel icon;
    JPanel[] panelHolder;
    int nCells;

    public IconPanel(int pos, BufferedImage icon, int dim1, int dim2) {
        nCells = dim1*dim2;
        this.panelHolder = new JPanel[nCells];

        setLayout(new GridLayout(dim1, dim2));
        setOpaque(false);
        
        createSwingImageComponent(icon);
        
        setCurrentPosition(pos);
    }

    private void fillLayout() {
        for (int element = 0; element < nCells; element++) {
            panelHolder[element] = new JPanel();
            add(panelHolder[element]);
        }
    }
    
    private void createSwingImageComponent(BufferedImage icon) {
        this.icon = new JLabel(new ImageIcon(icon));
    }
    
    public void updatePanel() {
        revalidate();
        repaint();
    }
    
    public void setCurrentPosition(int pos){
        fillLayout();
        panelHolder[pos].add(this.icon);
    }
}
