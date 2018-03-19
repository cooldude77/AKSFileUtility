package com.instanect.aksfileutility.generic.util;

import com.instanect.aksfileutility.generic.encoder.InstaNullValueProvided;

/**
 * AppMimeTypeToImageExtensionConverter
 */

public class AppBase64ImageDataFromMimeTypeTruncator {

    public String truncateImageTypeData(String imageBase64) throws InstaNullValueProvided, InstaBas64DataNotProcessedException {

        if (imageBase64 == null)
            throw new InstaNullValueProvided("Base image");

        if (imageBase64.startsWith("data:image/jpeg;base64,"))
            return imageBase64.substring(
                    "data:image/jpeg;base64,".length(),
                    imageBase64.length()
            );
        else if (imageBase64.startsWith("data:image/png;base64,"))
            return imageBase64.substring(
                    "data:image/png;base64,".length(),
                    imageBase64.length()
            );

        throw new InstaBas64DataNotProcessedException();
    }

}
