package com.rentpassing.androidarchitecture.mvp;

import android.annotation.SuppressLint;
import android.util.Log;
import com.rentpassing.androidarchitecture.model.Country;
import com.rentpassing.androidarchitecture.model.CountryServices;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class CountryPresenter {
    private final View view;
    private final CountryServices services;

    public CountryPresenter(View view) {
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
                        List<String> countryList = new ArrayList<>();
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

    public interface View{
        void setValues(List<String> countryNames);
        void handleError();
    }
}
