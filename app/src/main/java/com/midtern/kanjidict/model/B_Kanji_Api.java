package com.midtern.kanjidict.model;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface B_Kanji_Api {

    @GET("/api/v1/lesson/{level}")
    Single<List<B_Kanji>> get_B_Kanji(@Path("level") String level);
}
