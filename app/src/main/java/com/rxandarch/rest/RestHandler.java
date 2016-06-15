package com.rxandarch.rest;

/* Copyright (C) Fraunhofer IESE - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by sainikkumar, 15/06/16.
 */

import com.rxandarch.realm.Person;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;

/****
 * side effect class, db saving class
 */
public class RestHandler {


    @Inject
    private DDApi ddApi;


    public Observable<String> getSession(String openIdToken, String email, String password) {

        return this.ddApi.getSession(openIdToken, email, password).doOnNext(new Action1<String>() {
            @Override
            public void call(String s) {
                // save to Identity manger
            }
        }).doOnError(new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                // log it
            }
        });
    }


    public Observable<Person> gerPerson(String sessionId) {
        return this.ddApi.getPerson(sessionId).doOnNext(new Action1<Person>() {
            @Override
            public void call(Person person) {
                // save in realm
            }
        }).doOnError(new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                // log it
            }
        });
    }

}
