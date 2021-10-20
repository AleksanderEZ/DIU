package control;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class FileImageLoader implements ImageLoader {

    @Override
    public BufferedImage load(String path) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
        try {
            return ImageIO.read(stream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
