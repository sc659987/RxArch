package com.rxandarch.activity;
/* Copyright (C) Fraunhofer IESE - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by sainikkumar, 14/06/16.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rxandarch.gcm.GcmRxBus;

import javax.inject.Inject;

import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public abstract class AbstractActivity extends AppCompatActivity implements Action1<Object> {


    protected CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Inject
    GcmRxBus gcmRxBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeSubscription.add(gcmRxBus.getObservable().subscribe(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (compositeSubscription.isUnsubscribed())
            compositeSubscription.unsubscribe();
    }

}
