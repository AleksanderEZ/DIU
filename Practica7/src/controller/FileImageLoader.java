package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileImageLoader {

    public BufferedImage load(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
