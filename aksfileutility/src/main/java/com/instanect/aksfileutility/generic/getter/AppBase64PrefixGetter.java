package com.instanect.aksfileutility.generic.getter;

import com.instanect.aksfileutility.generic.exception.InstaNoSuchImageExtensionException;

/**
 * Provides data prefix for images to be transmitted to server
 */

public class AppBase64PrefixGetter {
    public String getPrefix(String fileNameOrPath) throws InstaNoSuchImageExtensionException {
        if (fileNameOrPath.endsWith("jpg") || fileNameOrPath.endsWith("jpeg"))
            return "data:image/jpeg;base64,";
        else if (fileNameOrPath.endsWith("png"))
            return "data:image/png;base64,";
        throw new InstaNoSuchImageExtensionException(fileNameOrPath);
    }
}
