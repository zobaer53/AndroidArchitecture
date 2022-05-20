package com.rentpassing.androidarchitecture.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// service that's gonna call the end pont and return information
public class CountryServices {
    public static final String baseURL = "https://restcountries.com/v2/";
    private CountryAPI api;

    public CountryServices(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(CountryAPI.class);
    }
    public Single<List<Country>> getCountries(){
        return api.getCountries();
    }
}
