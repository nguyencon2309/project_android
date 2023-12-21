package com.midtern.kanjidict;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.midtern.kanjidict.model.B_Kanji;
import com.midtern.kanjidict.model.B_Kanji_Api;
import com.midtern.kanjidict.model.C_Kanji;
import com.midtern.kanjidict.viewmodel.B_Kanji_Api_Service;
import com.midtern.kanjidict.viewmodel.C_Kanji_Api_Service;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private B_Kanji_Api_Service b_Api;
    private C_Kanji_Api_Service c_Api;
    private B_Kanji_Api b_kanji_api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        b_Api = new B_Kanji_Api_Service();
//
//        b_Api.get_B_Kanji("N5")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableSingleObserver<List<B_Kanji>>() {
//                    @Override
//                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<B_Kanji> list_b_kanji) {
//                        Log.d("DEBUG","Succes");
//
//                        for(B_Kanji dog :list_b_kanji){
//                            Log.d("DEBUG", "onSuccess: "+dog.getKanji());
////                            dogsBreeds.add(dog);
////                            dogsAdapter.notifyDataSetChanged();
//                        }
//                    }
//
//                    @Override
//                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
//                        Log.d("DEBUG","Fail"+e.getMessage());
//
//                    }
//                });


//        c_Api = new C_Kanji_Api_Service();
//        c_Api.get_C_Kanji(100)
//                .enqueue(new Callback<C_Kanji>() {
//                    @Override
//                    public void onResponse(Call<C_Kanji> call, Response<C_Kanji> response) {
//                        Log.d("DEBUG1","success body"+response.body().getKanji());
//                    }
//
//                    @Override
//                    public void onFailure(Call<C_Kanji> call, Throwable t) {
//
//                        Log.d("DEBUG1","fail"+t.getMessage());
//                    }
//                });




    }
}