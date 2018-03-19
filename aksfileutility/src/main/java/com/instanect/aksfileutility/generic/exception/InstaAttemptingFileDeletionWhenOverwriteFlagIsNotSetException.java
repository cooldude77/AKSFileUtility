package com.instanect.aksfileutility.generic.exception;

/**
 * Created by AKS on 2/14/2018.
 */

public class InstaAttemptingFileDeletionWhenOverwriteFlagIsNotSetException extends Exception {
    public InstaAttemptingFileDeletionWhenOverwriteFlagIsNotSetException(String completePathWithFileName) {

        super("Please set overwrite flag for file :" + completePathWithFileName);
    }
}
