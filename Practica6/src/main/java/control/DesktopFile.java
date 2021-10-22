package control;

import java.io.File;

public class DesktopFile extends File{

    public DesktopFile(){
        super(System.getProperty("user.home") + System.getProperty("file.separator")+ "Desktop");  
    }
}
