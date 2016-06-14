package com.rxandarch.activity;
/* Copyright (C) Fraunhofer IESE - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by sainikkumar, 14/06/16.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import rx.subscriptions.CompositeSubscription;

public class AbstractActivity extends AppCompatActivity {


    protected CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (compositeSubscription.isUnsubscribed())
            compositeSubscription.unsubscribe();
    }


}
