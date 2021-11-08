package control;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageFileSaver implements FileSaver {

    File selectedFile;
    BufferedImage image;
    
    public ImageFileSaver(File selectedFile, BufferedImage image) {
        this.selectedFile = selectedFile;
        this.image = image;
    }

    public void save() {
        try {
            ImageIO.write(image, "jpg", selectedFile);
        } catch (IOException ex) {
            Logger.getLogger(ImageFileSaver.class.getName()).log(Level.SEVERE, "No se pudo guardar el fichero", ex);
        }
    }

}
