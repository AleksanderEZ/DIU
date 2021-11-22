package control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.*;
import java.util.List;

public class Zipper {

    List<String> files = new ArrayList<>();
    private final int BUFFER_SIZE;

    public Zipper(int bufferSize) {
        BUFFER_SIZE = bufferSize;
    }

    public void zipFiles(String destination) {
        try {
            BufferedInputStream origin;
            FileOutputStream dest = new FileOutputStream(destination);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte[] data = new byte[BUFFER_SIZE];
            for (String filename : files) {
                FileInputStream fi = new FileInputStream(filename);
                origin = new BufferedInputStream(fi, BUFFER_SIZE);
                ZipEntry entry = new ZipEntry(filename);
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Error in Zipper::zipFiles - " + e.getMessage());
        }
    }

    public void addFileToCompressionGroup(String filePath) {
        files.add(filePath);
    }
}
