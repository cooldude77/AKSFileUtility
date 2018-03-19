package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/12/2018.
 */

public class InstaUnidentifiedImageFileExtensionException extends Exception {
    public InstaUnidentifiedImageFileExtensionException() {
        super("Only jpg,jpeg and png extension are processed. Please check the extension");
    }
}
