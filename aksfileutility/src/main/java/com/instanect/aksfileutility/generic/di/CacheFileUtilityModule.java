package com.instanect.aksfileutility.generic.di;

import android.content.Context;

import com.instanect.aksfileutility.generic.util.CacheFileUtility;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 1/29/2018.
 */

@Module
public class CacheFileUtilityModule {

    private Context context;

    public CacheFileUtilityModule(Context context) {

        this.context = context;
    }

    @Provides
    CacheFileUtility provideCacheFileUtility() {
        return new CacheFileUtility(context);
    }
}
