package control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import view.ProgressDialog;

public class Zipper extends SwingWorker<Void, Integer> {

    private JProgressBar progressBar;
    private ProgressDialog progressDialog;
    private List<String> files = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    private final int BUFFER_SIZE;
    
    private String destination;
    
    public Zipper(int bufferSize) {
        BUFFER_SIZE = bufferSize;
    }
    
    public Zipper(int bufferSize, ProgressDialog progressDialog) {
        BUFFER_SIZE = bufferSize;
        this.progressDialog = progressDialog;
        this.progressBar = progressDialog.getProgressBar();
        this.progressBar.setMaximum(files.size());
    }

    public void zipFiles(String destination) {
        this.destination = destination;
        progressBar.setMaximum(files.size());
    }

    public void addFileToCompressionGroup(String filePath, String fileName) {
        files.add(filePath);
        names.add(fileName);
    }

    @Override
    protected void process(List<Integer> chunks) {
        int i = chunks.get(chunks.size()-1);
        System.out.println(i+1+" sobre "+files.size());
        progressBar.setValue(i);
    }
    
    @Override
    protected Void doInBackground() throws Exception {
        if(!destination.endsWith(".zip")){
            destination += ".zip";
        }
        try {
            BufferedInputStream origin;
            FileOutputStream dest = new FileOutputStream(destination);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte[] data = new byte[BUFFER_SIZE];
            for (int i = 0; i < files.size(); i++) {
                String filepath = files.get(i);
                String filename = names.get(i);
                FileInputStream fi = new FileInputStream(filepath);
                origin = new BufferedInputStream(fi, BUFFER_SIZE);
                ZipEntry entry = new ZipEntry(filename);
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
                
                publish(i);
                if (Thread.interrupted()) throw new InterruptedException();
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Error in Zipper::zipFiles - " + e.getMessage());
        } catch (InterruptedException e) {
            return null;
        }
        return null;
    }
    
    @Override
    protected void done() {
        progressDialog.setVisible(false);
        files.clear();
        if (isCancelled()) {
            File zipFile = new File(destination);
            zipFile.delete();
        }
    }
}
