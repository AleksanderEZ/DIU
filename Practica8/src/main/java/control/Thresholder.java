package control;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import static org.opencv.highgui.HighGui.toBufferedImage;
import org.opencv.imgproc.Imgproc;

public class Thresholder {

    public static BufferedImage applyThreshold(BufferedImage image, Integer threshold) {

        Mat original = toMat(image);
        // crear dos imágenes en niveles de gris con el mismo
        // tamaño que la original
        Mat imagenGris = new Mat(original.rows(),
                original.cols(),
                CvType.CV_8U);
        Mat imagenUmbralizada = new Mat(original.rows(),
                original.cols(),
                CvType.CV_8U);
        // convierte a niveles de grises la imagen original
        Imgproc.cvtColor(original,
                imagenGris,
                Imgproc.COLOR_BGR2GRAY);
        // umbraliza la imagen:
        // - píxeles con nivel de gris > umbral se ponen a 1
        // - píxeles con nivel de gris <= umbra se ponen a 0
        Imgproc.threshold(imagenGris,
                imagenUmbralizada,
                threshold,
                255,
                Imgproc.THRESH_BINARY);
        // se devuelve la imagen umbralizada
        return (BufferedImage) toBufferedImage(imagenUmbralizada);
    }

    private static Mat toMat(BufferedImage image) {
        int imageComponents = image.getColorModel().getNumComponents();
        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        Mat image_final = new Mat(image.getHeight(), image.getWidth(), getImageType(imageComponents));
        image_final.put(0, 0, pixels);
        return image_final;
    }
    
    private static int getImageType(int imageComponents) {
        Field field = null;
        try {
            field = CvType.class.getField("CV_8UC" + imageComponents);
        } catch (NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(Thresholder.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return field.getInt(field);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Thresholder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
