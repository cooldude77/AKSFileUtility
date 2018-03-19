package com.instanect.aksfileutility.di;

import android.content.Context;

import com.instanect.fileutility.generic.converter.AppStringToByteImageConverter;
import com.instanect.fileutility.generic.encoder.AppImageFileToBase64Encoder;
import com.instanect.fileutility.generic.getter.AppBase64PrefixGetter;
import com.instanect.fileutility.generic.getter.AppImageExtensionGetter;
import com.instanect.fileutility.generic.providers.AppFileInstanceProvider;
import com.instanect.fileutility.generic.providers.FileInputStreamProvider;
import com.instanect.fileutility.generic.providers.FileOutputStreamProvider;
import com.instanect.fileutility.generic.util.AppBase64ImageDataFromMimeTypeTruncator;
import com.instanect.fileutility.generic.util.AppDirectoryUtility;
import com.instanect.fileutility.generic.util.AppFileByteReader;
import com.instanect.fileutility.generic.util.AppFileStreamWriter;
import com.instanect.fileutility.generic.util.AppFileUtility;
import com.instanect.fileutility.generic.util.AppMimeTypeToImageExtensionConverter;
import com.instanect.fileutility.generic.util.CacheFileUtility;

import dagger.Module;
import dagger.Provides;


/**
 * AppFileUtilitiesModule
 */

@Module
public class AppFileUtilitiesModule {

    private final Context context;

    public AppFileUtilitiesModule(Context context) {

        this.context = context;
    }

    @Provides
    public AppFileUtility provideAppFileUtility() {

        return new AppFileUtility(
                new AppFileInstanceProvider(),
                new AppFileStreamWriter(
                        new FileInputStreamProvider(),
                        new FileOutputStreamProvider()
                ));
    }

    @Provides
    public AppDirectoryUtility provideAppDirectoryUtility() {

        return new AppDirectoryUtility(
                new AppFileInstanceProvider()
        );
    }

    @Provides
    public AppMimeTypeToImageExtensionConverter provideAppMimeTypeToImageExtensionConverter() {
        return new AppMimeTypeToImageExtensionConverter();
    }

    @Provides
    public AppStringToByteImageConverter provideAppStringToByteImageConverter() {
        return new AppStringToByteImageConverter();
    }

    @Provides
    public AppFileInstanceProvider provideAppFileInstanceProvider() {
        return new AppFileInstanceProvider();
    }

    @Provides
    public AppImageFileToBase64Encoder provideAppImageFileToBase64Encoder(AppFileUtility appFileUtility) {
        return new AppImageFileToBase64Encoder(
                new AppFileByteReader(appFileUtility),
                new AppBase64PrefixGetter());
    }

    @Provides
    public AppImageExtensionGetter provideAppImageExtensionGetter() {
        return new AppImageExtensionGetter();
    }

    @Provides
    public CacheFileUtility provideCacheFileUtility() {
        return new CacheFileUtility(context);
    }

    @Provides
    public AppFileStreamWriter provideAppFileStreamWriter() {
        return new AppFileStreamWriter(new FileInputStreamProvider(),
                new FileOutputStreamProvider());
    }

    @Provides
    public AppBase64ImageDataFromMimeTypeTruncator provideAppBase64ImageDataFromMimeTypeTruncator() {
        return new AppBase64ImageDataFromMimeTypeTruncator();
    }
}
