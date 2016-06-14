package com.rxandarch.module;

/* Copyright (C) Fraunhofer IESE - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by sainikkumar, 14/06/16.
 */

import android.content.Context;
import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rxandarch.R;
import com.rxandarch.rest.DDApi;

import java.io.IOException;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Inject
    Context context;

    @Provides
    DDApi provideDDServerInterface() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {

                return chain.proceed(chain.request().newBuilder()
                        .addHeader("User-Agent", Build.MANUFACTURER
                                + " " + Build.MODEL + ", " +
                                "Android " + Build.VERSION.RELEASE
                                + " (" + Build.VERSION.SDK_INT).build());
            }
        });


        //System.out.print(context.getCacheDir().toString());


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.baseServiceUrl))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(DDApi.class);

    }
}
