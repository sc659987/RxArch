package com.rxandarch.module;

/* Copyright (C) Fraunhofer IESE - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by sainikkumar, 14/06/16.
 */

import com.rxandarch.activity.AbstractActivity;
import com.rxandarch.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppContextModule.class})
public interface ApplicationComponent {

    // inject in MainActivity
    void inject(MainActivity activity);

    // inject in AbstractActivity
    //void inject(AbstractActivity activity);

}
