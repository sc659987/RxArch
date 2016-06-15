package com.rxandarch.activity;

import android.os.Bundle;

import com.rxandarch.R;
import com.rxandarch.realm.Person;
import com.rxandarch.rest.RestHandler;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AbstractActivity {

    @Inject
    RestHandler restHandler;

    @Inject
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // get person
        compositeSubscription.add(
                // ask for sessionId using email id and password
                restHandler.getSession("", "sainik.kumar@gmail.com", "12345678")
                        // on success it will return sessionId which is used to get get person
                        .flatMap(sessionId -> {
                            return restHandler.gerPerson(sessionId)
                                    .map(person -> {
                                        return person.getId();
                                    });
                        })
                        // all happening in backend io thread pool
                        .subscribeOn(Schedulers.io())
                        // on success it will change it to main thread
                        .observeOn(AndroidSchedulers.mainThread())
                        // thread change so retrieve the value from realm using current thread
                        .flatMap(s -> {
                            return Observable.just(realm.where(Person.class).equalTo("id", s).findFirst());
                        })
                        .subscribe(new Subscriber<Person>() {
                            @Override
                            public void onCompleted() {
                                // show successfully
                            }

                            @Override
                            public void onError(Throwable e) {
                                // show user that it's not possible
                            }

                            @Override
                            public void onNext(Person person) {
                                // update Ui
                            }
                        }));
        // subscribing to gcm bus

    }

    @Override
    public void call(Object o) {


        // handle GCM call

    }


}
