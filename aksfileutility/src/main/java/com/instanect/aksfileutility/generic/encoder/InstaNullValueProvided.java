package com.instanect.aksfileutility.generic.encoder;

/**
 * Created by AKS on 2/13/2018.
 */

public class InstaNullValueProvided extends Exception {
    public InstaNullValueProvided(String text) {

        super(text + " cannot be null");
    }
}
