package com.midtern.kanjidict.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface C_Kanji_Api {
    @GET("api/v1/detail/{id}")
    Call<C_Kanji> get_C_Kanji(@Path("id") int id);


}
