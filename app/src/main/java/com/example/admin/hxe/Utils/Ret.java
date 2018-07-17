package com.example.admin.hxe.Utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:anqi    Q 1677564461 2018-7-11.
 */
public class Ret {
    private static  Ret ret;
    private String url="https://www.zhaoapi.cn/";
    public static Ret getRet() {
     if(ret==null){
         ret=new Ret();
     }
        return ret;
    }

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(5000, TimeUnit.SECONDS)
            .readTimeout(5000, TimeUnit.SECONDS)
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build();

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
