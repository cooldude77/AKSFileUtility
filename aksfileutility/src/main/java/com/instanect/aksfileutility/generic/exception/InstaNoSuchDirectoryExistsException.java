package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/12/2018.
 */

public class InstaNoSuchDirectoryExistsException extends Exception {
    public InstaNoSuchDirectoryExistsException(String directory) {
        super("No such directory exists : " + directory);
    }
}
