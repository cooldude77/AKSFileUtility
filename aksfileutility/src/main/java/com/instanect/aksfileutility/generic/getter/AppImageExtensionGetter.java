package com.instanect.aksfileutility.generic.getter;

import com.instanect.fileutility.generic.exception.InstaUnidentifiedImageFileExtensionException;

/**
 * Created by AKS on 2/9/2018.
 */

public class AppImageExtensionGetter {


    public String getExtension(String fileName) throws InstaUnidentifiedImageFileExtensionException {
        if (fileName.endsWith("jpg") || fileName.endsWith("jpeg")) return "jpg";
        else if (fileName.endsWith("png")) return "png";

        throw new InstaUnidentifiedImageFileExtensionException();
    }

}
