package control;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileImageLoader implements ImageLoader{
    
    String path;
    
    public FileImageLoader(String path){
        this.path = path;
    }
    
    @Override
    public BufferedImage load() {
        return getImage();
    }
    
    private BufferedImage getImage(){
        File file = new File(path);
        try {
            return ImageIO.read(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
