package com.midtern.kanjidict.viewmodel;

import androidx.annotation.NonNull;

import com.midtern.kanjidict.model.B_Kanji;
import com.midtern.kanjidict.model.B_Kanji_Api;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

public class B_Kanji_Api_Service {
    private static final String BASIC_URL = "http://192.168.1.11:3000";
    private B_Kanji_Api api;


    public B_Kanji_Api_Service(){
        api = new Retrofit.Builder()
                .baseUrl(BASIC_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(B_Kanji_Api.class);

    }
    public Single<List<B_Kanji>> get_B_Kanji(String level){

        return api.get_B_Kanji(level);
    }


}
/*
private static final String BASIC_URL = "https://raw.githubusercontent.com";  get_B_Kanji
    private DogsApi api;

    public DogsApiService(){
        api = new Retrofit.Builder()
                .baseUrl(BASIC_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(DogsApi.class);

    }
    public Single<List<DogBreed>> getDogs(){
        return api.getDogs();
    }
 */
