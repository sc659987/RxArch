package com.rxandarch.gcm;

/* Copyright (C) Fraunhofer IESE - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by sainikkumar, 15/06/16.
 */

import rx.Observable;
import rx.subjects.PublishSubject;

/***
 *
 */
public class GcmRxBus {

    private PublishSubject<Object> gcmRxBus = PublishSubject.create();

    /**
     * Pass any event down to event listeners.
     */
    public void publish(Object object) {
        gcmRxBus.onNext(object);
    }

    /**
     * Subscribe to this Observable. On event, do something
     * e.g. replace a fragment
     */
    public Observable<Object> getObservable() {
        return gcmRxBus;
    }

}
