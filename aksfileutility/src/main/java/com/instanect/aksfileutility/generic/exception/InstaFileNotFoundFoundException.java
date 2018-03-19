package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/12/2018.
 */

public class InstaFileNotFoundFoundException extends Exception {
    public InstaFileNotFoundFoundException(String fileAbsolutePath) {
        super("No file exists on path : " + fileAbsolutePath);
    }
}
