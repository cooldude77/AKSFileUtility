package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/12/2018.
 */

public class InstaMimeTypeNotRecognizedException extends Exception {
    public InstaMimeTypeNotRecognizedException(String mimeType) {
        super(mimeType + " not recognized");
    }
}
