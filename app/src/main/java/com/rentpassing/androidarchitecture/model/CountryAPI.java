package com.rentpassing.androidarchitecture.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

//this is here retrofit http get request happens

public interface CountryAPI {
    @GET("all") //getting all data from endpoint "all"
    Single<List<Country>> getCountries(); //
}
