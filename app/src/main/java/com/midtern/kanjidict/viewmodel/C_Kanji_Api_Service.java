package com.midtern.kanjidict.viewmodel;

import com.midtern.kanjidict.model.C_Kanji;
import com.midtern.kanjidict.model.C_Kanji_Api;


import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class C_Kanji_Api_Service {

    private static final String BASIC_URL = "http://192.168.1.11:3000";
    private C_Kanji_Api api;


    public C_Kanji_Api_Service(){
        api = new Retrofit.Builder()
                .baseUrl(BASIC_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(C_Kanji_Api.class);

    }
    public Call<C_Kanji> get_C_Kanji(int id){

        return api.get_C_Kanji(id);
    }

}
