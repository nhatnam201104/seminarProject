package com.example.frontend.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static final String API_BASE_URL = "https://jsonplaceholder.typicode.com";
    private static Retrofit retrofit = null;

    public static Retrofit init () {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static <S> S createService (Class<S> serviceClass) {
        return init().create(serviceClass);
    }
}
