package control;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class FileImageLoader implements ImageLoader{
    
    String path;
    
    public FileImageLoader(String path) {
        this.path = path;
    }
    
    @Override
    public BufferedImage load() {
        return getImage();
    }
    
    private BufferedImage getImage() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
        try {
            return ImageIO.read(stream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
