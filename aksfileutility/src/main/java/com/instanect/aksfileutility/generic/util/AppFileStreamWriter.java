package com.instanect.aksfileutility.generic.util;

import com.instanect.aksfileutility.generic.providers.FileInputStreamProvider;
import com.instanect.aksfileutility.generic.providers.FileOutputStreamProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by AKS on 2/1/2018.
 */

public class AppFileStreamWriter {

    private final FileInputStreamProvider fileInputStreamProvider;
    private final FileOutputStreamProvider fileOutputStreamProvider;

    public AppFileStreamWriter(FileInputStreamProvider fileInputStreamProvider,
                               FileOutputStreamProvider fileOutputStreamProvider) {

        this.fileInputStreamProvider = fileInputStreamProvider;
        this.fileOutputStreamProvider = fileOutputStreamProvider;
    }

    public void writeFromFileToFile(String inFile, String outFile) throws IOException {
        FileInputStream in = fileInputStreamProvider.getInstance(inFile);

        FileOutputStream out = fileOutputStreamProvider.getInstance(outFile);

        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
        in.close();

        // write the output file
        out.flush();
        out.close();

    }

    public void writeFromBytes(byte[] imageByteArray, String filePath)
            throws IOException {

        FileOutputStream fos = fileOutputStreamProvider.getInstance(filePath);

        fos.write(imageByteArray);
        fos.close();
    }
}
