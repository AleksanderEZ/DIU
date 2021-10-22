package control;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import static org.opencv.highgui.HighGui.toBufferedImage;
import org.opencv.imgproc.Imgproc;

public class Thresholder {

    public static BufferedImage applyThreshold(BufferedImage image, Integer threshold) {
        loadThresholdingLibrary();

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

    private static void loadThresholdingLibrary() {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    private static Mat toMat(BufferedImage image) {
        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        Mat image_final = null;
        image_final.put(0, 0, pixels);
        return image_final;
    }
}
