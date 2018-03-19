package com.instanect.aksfileutility.generic.converter;

import android.util.Base64;

/**
 * Created by AKS on 1/31/2018.
 */

public class AppStringToByteImageConverter {

    public byte[] convert(String base64) {

        return Base64.decode(base64, Base64.DEFAULT);

    }
}
