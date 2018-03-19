package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/12/2018.
 */

public class InstaNoSuchImageExtensionException extends Exception {
    public InstaNoSuchImageExtensionException(String extension) {
        super("No such extension found =" + extension);
    }
}
