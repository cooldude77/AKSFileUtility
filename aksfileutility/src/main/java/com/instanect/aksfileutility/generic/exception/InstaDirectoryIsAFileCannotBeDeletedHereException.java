package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/12/2018.
 */

public class InstaDirectoryIsAFileCannotBeDeletedHereException extends Exception {
    public InstaDirectoryIsAFileCannotBeDeletedHereException(String dirPath) {
        super("Directory is a file and cannot be deleted by this function :" + dirPath);
    }
}
