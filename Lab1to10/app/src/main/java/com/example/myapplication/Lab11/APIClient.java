package com.example.myapplication.Lab11;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static String baseURL = "https://67e5bf7118194932a5872398.mockapi.io/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
