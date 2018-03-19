package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/12/2018.
 */

public class InstaDirectoryIsActuallyAFileException extends Exception {
    public InstaDirectoryIsActuallyAFileException(String pathDir) {
        super("The path provided is a File: " + pathDir);
    }
}
