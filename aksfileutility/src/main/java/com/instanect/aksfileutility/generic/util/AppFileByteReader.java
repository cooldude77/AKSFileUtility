package com.instanect.aksfileutility.generic.util;

import com.instanect.fileutility.generic.exception.InstaFileNotFoundFoundException;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by AKS on 2/12/2018.
 */

public class AppFileByteReader {
    private final AppFileUtility appFileUtility;

    public AppFileByteReader(AppFileUtility appFileUtility) {

        this.appFileUtility = appFileUtility;
    }

    public byte[] getBytes(String pathToFile)
            throws InstaFileNotFoundFoundException, FileNotFoundException {

        byte[] bytes;
        byte[] buffer = new byte[8192];
        int bytesRead;

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        InputStream inputStream = new FileInputStream(pathToFile);

        try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bytes = output.toByteArray();
        return bytes;
    }
}
