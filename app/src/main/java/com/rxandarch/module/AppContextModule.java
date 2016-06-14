package com.rxandarch.module;
/* Copyright (C) Fraunhofer IESE - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by sainikkumar, 14/06/16.
 */


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppContextModule {

    private Application mApp;

    public AppContextModule(Application mApp) {
        this.mApp = mApp;
    }

    @Provides
    @Singleton
    Context getContext() {
        return mApp.getApplicationContext();
    }
}
