package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/12/2018.
 */

public class InstaDirectoryCouldNotBeDeletedException extends Exception {
    public InstaDirectoryCouldNotBeDeletedException(String directory) {
        super("Directory could not be deleted : " + directory);
    }
}
