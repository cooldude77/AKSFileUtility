package com.instanect.aksfileutility.generic.providers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by AKS on 1/29/2018.
 */

public class FileOutputStreamProvider {
    public FileOutputStream getInstance(String fileNameWithPath) throws FileNotFoundException {
        return new FileOutputStream(fileNameWithPath);
    }
}
