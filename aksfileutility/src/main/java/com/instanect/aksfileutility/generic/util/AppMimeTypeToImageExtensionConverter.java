package com.instanect.aksfileutility.generic.util;

import com.instanect.fileutility.generic.exception.InstaMimeTypeNotRecognizedException;

/**
 AppMimeTypeToImageExtensionConverter
 */

public class AppMimeTypeToImageExtensionConverter {
    public String getImageExtension(String mimeType)
            throws IllegalArgumentException, InstaMimeTypeNotRecognizedException {
        if (mimeType.equals("image/png"))
            return "png";
        if (mimeType.equals("image/jpeg"))
            return "jpg";

        throw new InstaMimeTypeNotRecognizedException(mimeType);
    }

}
