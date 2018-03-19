package com.instanect.aksfileutility.di;

import android.content.Context;

import com.instanect.aksfileutility.generic.converter.AppStringToByteImageConverter;
import com.instanect.aksfileutility.generic.encoder.AppImageFileToBase64Encoder;
import com.instanect.aksfileutility.generic.getter.AppBase64PrefixGetter;
import com.instanect.aksfileutility.generic.getter.AppImageExtensionGetter;
import com.instanect.aksfileutility.generic.providers.AppFileInstanceProvider;
import com.instanect.aksfileutility.generic.providers.FileInputStreamProvider;
import com.instanect.aksfileutility.generic.providers.FileOutputStreamProvider;
import com.instanect.aksfileutility.generic.util.AppBase64ImageDataFromMimeTypeTruncator;
import com.instanect.aksfileutility.generic.util.AppDirectoryUtility;
import com.instanect.aksfileutility.generic.util.AppFileByteReader;
import com.instanect.aksfileutility.generic.util.AppFileStreamWriter;
import com.instanect.aksfileutility.generic.util.AppFileUtility;
import com.instanect.aksfileutility.generic.util.AppMimeTypeToImageExtensionConverter;
import com.instanect.aksfileutility.generic.util.CacheFileUtility;

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
