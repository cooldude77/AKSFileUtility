package com.instanect.aksfileutility.generic.providers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by AKS on 1/29/2018.
 */

public class FileInputStreamProvider {
    public FileInputStream getInstance(String path) throws FileNotFoundException {
        return new FileInputStream(path);
    }
}
