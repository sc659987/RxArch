package com.rxandarch.activity;

import android.os.Bundle;

import com.rxandarch.R;
import com.rxandarch.realm.Person;
import com.rxandarch.rest.DDApi;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AbstractActivity {

    @Inject
    private DDApi ddApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        compositeSubscription.add(ddApi.getPerson()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                })
                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person person) {

                    }
                }));

    }
}
