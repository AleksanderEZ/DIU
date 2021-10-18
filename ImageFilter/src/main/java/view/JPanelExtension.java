package view;

import javax.swing.JPanel;

public class JPanelExtension extends JPanel{
    private final String name;
    private final int age;
    private final int nChildren;

    public JPanelExtension(String name, int age, int nChildren) {
        this.name = name;
        this.age = age;
        this.nChildren = nChildren;
    }
}
