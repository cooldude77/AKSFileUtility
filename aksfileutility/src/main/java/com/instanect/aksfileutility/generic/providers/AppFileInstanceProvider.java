package com.instanect.aksfileutility.generic.providers;

import android.net.Uri;

import java.io.File;
import java.io.IOException;

/**
 * Created by AKS on 1/29/2018.
 */

public class AppFileInstanceProvider {
    public File getInstance(Uri fileUri) {
        return new File(fileUri.getPath());
    }

    public File getInstance(String filePath) {
        return new File(filePath);
    }

    public File create(String filePath) throws IOException {

        File file = new File(filePath);
        if (!file.exists()) {
            boolean bool = file.createNewFile();
        }

        return file;
    }
}
