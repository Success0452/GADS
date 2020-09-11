package com.famous.gadsleaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api
{

    private static final String BASE_URL = "https://gadsapi.herokuapp.com";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
