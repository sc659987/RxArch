package com.rxandarch.rest;


/* Copyright (C) Fraunhofer IESE - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by sainik kumar, 13/06/16.
 */

import com.rxandarch.realm.Person;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import rx.Observable;

/*****
 * These are cold Observable
 */
public interface DDApi {


    @GET("/authentication/session")
    Observable<String> getSession(@Header("openidtoken") String username, @Header("email") String email, @Header("password") String password);

    @GET("/person")
    Observable<Person> getPerson();

    @POST("/person")
    Observable<Person> postPerson(@Body Person person, @Header("identity") String identity, @Header("password") String password);

    @PUT("/person")
    Observable<Person> putPerson(@Body Person person);


}
