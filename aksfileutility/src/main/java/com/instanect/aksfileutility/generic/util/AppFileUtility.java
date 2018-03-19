package com.instanect.aksfileutility.generic.util;

import com.instanect.fileutility.LogTagGenerator;
import com.instanect.fileutility.generic.exception.InstUnableToCreateFileException;
import com.instanect.fileutility.generic.exception.InstaAttemptingFileDeletionWhenOverwriteFlagIsNotSetException;
import com.instanect.fileutility.generic.exception.InstaFileNotFoundFoundException;
import com.instanect.fileutility.generic.exception.InstaUnableToDeleteFileException;
import com.instanect.fileutility.generic.providers.AppFileInstanceProvider;

import java.io.File;
import java.io.IOException;

/**
 * To manage creation/deletion of files
 */

public class AppFileUtility {


    private final String TAG = LogTagGenerator.getTag(AppFileUtility.class);

    private final AppFileInstanceProvider appFileInstanceProvider;
    private final AppFileStreamWriter appFileStreamWriter;

    public AppFileUtility(
            AppFileInstanceProvider appFileInstanceProvider,
            AppFileStreamWriter appFileStreamWriter) {

        this.appFileInstanceProvider = appFileInstanceProvider;
        this.appFileStreamWriter = appFileStreamWriter;
    }

    void createFile(String completePathWithFileName, boolean overwriteIfExists)
            throws
            IOException,
            InstaUnableToDeleteFileException,
            InstaAttemptingFileDeletionWhenOverwriteFlagIsNotSetException,
            InstUnableToCreateFileException, InstaFileNotFoundFoundException {

        File file = appFileInstanceProvider.getInstance(completePathWithFileName);

        if (file.exists())
            if (overwriteIfExists) {
                deleteFile(completePathWithFileName);
            } else {
                throw new InstaAttemptingFileDeletionWhenOverwriteFlagIsNotSetException(
                        completePathWithFileName);
            }

        boolean created = file.createNewFile();

        if (!created)
            throw new InstUnableToCreateFileException(completePathWithFileName);
    }


    public void moveFile(String moveFromFullPathToFile, String toFullPathToFile)
            throws IOException, InstaFileNotFoundFoundException, InstaUnableToDeleteFileException {

        // delete the original file
        File origFile = appFileInstanceProvider.getInstance(moveFromFullPathToFile);

        if (!origFile.exists())
            throw new InstaFileNotFoundFoundException(origFile.getAbsolutePath());

        appFileStreamWriter.writeFromFileToFile(moveFromFullPathToFile, toFullPathToFile);

        deleteFile(moveFromFullPathToFile);

    }

    public void deleteFile(File file) throws InstaFileNotFoundFoundException, InstaUnableToDeleteFileException {
        if (!file.exists())
            throw new InstaFileNotFoundFoundException(file.getAbsolutePath());
        else
            deleteFile(file.getAbsolutePath());
    }

    public void deleteFile(String filePath) throws InstaFileNotFoundFoundException,
            InstaUnableToDeleteFileException {

        File file = appFileInstanceProvider.getInstance(filePath);

        if (file.exists()) {
            boolean deleted = file.delete();

            if (!deleted)
                throw new InstaUnableToDeleteFileException(file.getAbsolutePath());
        } else
            throw new InstaFileNotFoundFoundException(file.getAbsolutePath());
    }

    public File getFile(String path) throws InstaFileNotFoundFoundException {
        File file = appFileInstanceProvider.getInstance(path);
        if (!file.exists())
            throw new InstaFileNotFoundFoundException(path);
        return file;

    }
}
