package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/12/2018.
 */

public class InstaDirectoryCouldNotBeCreatedException extends Exception {
    public InstaDirectoryCouldNotBeCreatedException(String pathToDirectory) {
        super("The directory could not be created :" + pathToDirectory);
    }
}
