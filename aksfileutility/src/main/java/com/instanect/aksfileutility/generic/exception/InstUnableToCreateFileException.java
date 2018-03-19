package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/14/2018.
 */

public class InstUnableToCreateFileException extends Exception {
    public InstUnableToCreateFileException(String completePathWithFileName) {
        super("Unable to create filename  : " + completePathWithFileName);
    }
}
