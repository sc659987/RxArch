package com.rxandarch;
/* Copyright (C) Fraunhofer IESE - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by sainikkumar, 14/06/16.
 */

import android.app.Application;

import com.rxandarch.module.AppContextModule;
import com.rxandarch.module.ApplicationComponent;
import com.rxandarch.module.DaggerApplicationComponent;

public class DDApp extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder()
                .appContextModule(new AppContextModule(this))
                .build();
    }
}
