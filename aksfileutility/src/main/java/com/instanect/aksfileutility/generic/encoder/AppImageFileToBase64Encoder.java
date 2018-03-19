package com.instanect.aksfileutility.generic.encoder;

import android.util.Base64;

import com.instanect.aksfileutility.generic.exception.InstaFileNotFoundFoundException;
import com.instanect.aksfileutility.generic.exception.InstaNoSuchImageExtensionException;
import com.instanect.aksfileutility.generic.getter.AppBase64PrefixGetter;
import com.instanect.aksfileutility.generic.util.AppFileByteReader;

import java.io.FileNotFoundException;

/**
 * Created by AKS on 2/8/2018.
 */

public class AppImageFileToBase64Encoder {

    private final AppFileByteReader appFileByteReader;
    private final AppBase64PrefixGetter appBase64PrefixGetter;

    public AppImageFileToBase64Encoder(AppFileByteReader appFileByteReader,
                                       AppBase64PrefixGetter appBase64PrefixGetter) {
        this.appFileByteReader = appFileByteReader;
        this.appBase64PrefixGetter = appBase64PrefixGetter;
    }

    public String getBase64EncodedStringFromFile(String pathToFile)
            throws InstaFileNotFoundFoundException, InstaNoSuchImageExtensionException, InstaNullValueProvided, FileNotFoundException {
        if (pathToFile == null)
            throw new InstaNullValueProvided("Path To file ");
        byte[] fileInBytes = appFileByteReader.getBytes(pathToFile);

        String prefix = appBase64PrefixGetter.getPrefix(pathToFile);

        return prefix + Base64.encodeToString(fileInBytes, Base64.DEFAULT);

    }
}
