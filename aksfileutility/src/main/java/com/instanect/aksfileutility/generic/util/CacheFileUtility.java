package com.instanect.aksfileutility.generic.util;

import android.content.Context;
import android.net.Uri;

import com.instanect.fileutility.LogTagGenerator;

import java.io.File;
import java.net.URI;

/**
 * Created by AKS on 1/29/2018.
 */

public class CacheFileUtility {

    private final String TAG = LogTagGenerator.getTag(CacheFileUtility.class);
    private final Context context;

    public CacheFileUtility(Context context) {

        this.context = context;
    }

    public boolean checkIfUriFromCache(Uri fileUri) {

        File file = new File(URI.create(fileUri.getPath()).getPath());

        if (!file.exists())
            return false;

        return isInCache(file);

    }

    private boolean isInCache(File file) {
        File f = file;
        while (f.getParentFile() != null) {

            f = f.getParentFile();
            if (f.equals(context.getCacheDir()))
                return true;
        }

        return false;
    }

}
