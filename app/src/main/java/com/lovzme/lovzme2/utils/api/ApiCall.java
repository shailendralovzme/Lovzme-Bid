package com.lovzme.lovzme2.utils.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCall {
    public static String BaseUrl = "https://api.100percentback.in/app/v1/";

    public static Retrofit retrofit = null;

   public static Retrofit getRetrofit() {
       if (retrofit == null) {
           HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
           interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
           OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                   .connectTimeout(100, TimeUnit.SECONDS)
                   .readTimeout(100, TimeUnit.SECONDS).build();
           retrofit = new Retrofit.Builder().baseUrl(BaseUrl)
                   .addConverterFactory(GsonConverterFactory.create()).client(client).build();
       }
       return retrofit;
   }

}
