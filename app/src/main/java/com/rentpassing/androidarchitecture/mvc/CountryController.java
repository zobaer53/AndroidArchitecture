package com.rentpassing.androidarchitecture.mvc;

import android.annotation.SuppressLint;
import android.util.Log;

import com.rentpassing.androidarchitecture.model.Country;
import com.rentpassing.androidarchitecture.model.CountryServices;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class CountryController {
    private MVCActivity view;
    private  List<String> countryList;
    private final CountryServices services;

    public CountryController(MVCActivity view) {
        this.view = view;
        services = new CountryServices();
        fetchCountries();
    }

    @SuppressLint("CheckResult")
    private void fetchCountries() {
        services.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {

                    @Override
                    public void onSuccess(List<Country> countries) {
                        countryList = new ArrayList<>();
                        for(Country country: countries){
                            countryList.add(country.countryName);
                            Log.i("CountryNames",country.countryName);
                        }
                        view.setValues(countryList);

                    }

                    @Override
                    public void onError(Throwable e) {

                        view.handleError();
                    }
                });
    }
    public void onRefresh(){
        fetchCountries();
    }
}
