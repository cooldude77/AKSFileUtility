package com.instanect.aksfileutility.generic.util;

import com.instanect.aksfileutility.generic.exception.InstaDirectoryCouldNotBeCreatedException;
import com.instanect.aksfileutility.generic.exception.InstaDirectoryCouldNotBeDeletedException;
import com.instanect.aksfileutility.generic.exception.InstaDirectoryIsAFileCannotBeDeletedHereException;
import com.instanect.aksfileutility.generic.exception.InstaDirectoryIsActuallyAFileException;
import com.instanect.aksfileutility.generic.exception.InstaNoSuchDirectoryExistsException;
import com.instanect.aksfileutility.generic.providers.AppFileInstanceProvider;

import java.io.File;

/**
 * Created by AKS on 2/1/2018.
 */

public class AppDirectoryUtility {
    private final AppFileInstanceProvider appFileInstanceProvider;

    public AppDirectoryUtility(AppFileInstanceProvider appFileInstanceProvider) {
        this.appFileInstanceProvider = appFileInstanceProvider;
    }

    public void checkAndCreateDirectory(String pathToDirectory)
            throws InstaDirectoryIsActuallyAFileException,
            InstaDirectoryCouldNotBeCreatedException {

        File dir = new File(pathToDirectory);
        if (dir.exists()) {
            if (!dir.isDirectory())
                throw new InstaDirectoryIsActuallyAFileException(pathToDirectory);
        } else {
            if (!dir.exists()) {
                boolean dirCreated = dir.mkdirs();
                if (!dirCreated)
                    throw new InstaDirectoryCouldNotBeCreatedException(pathToDirectory);
            }
        }

    }

    @SuppressWarnings("ControlFlowStatementWithoutBraces")
    public void removeDirectory(String dir)
            throws InstaNoSuchDirectoryExistsException,
            InstaDirectoryIsAFileCannotBeDeletedHereException,
            InstaDirectoryCouldNotBeDeletedException {

        File directory = appFileInstanceProvider.getInstance(dir);

        if (!directory.exists())
            throw new InstaNoSuchDirectoryExistsException(dir);
        if (directory.isFile()) {
            throw new InstaDirectoryIsAFileCannotBeDeletedHereException(dir);
        }
        removeRecursively(directory);

    }


    private void removeRecursively(File directory) throws InstaDirectoryCouldNotBeDeletedException {

        if (directory.isDirectory())
            for (File child : directory.listFiles())
                removeRecursively(child);

        if (!directory.delete())
            throw new InstaDirectoryCouldNotBeDeletedException(directory.getAbsolutePath());
    }

}
