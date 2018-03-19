package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/14/2018.
 */

public class InstaUnableToDeleteFileException extends Exception {
    public InstaUnableToDeleteFileException(String completePathWithFileName) {
        super("File could not be deleted :" + completePathWithFileName);
    }
}
