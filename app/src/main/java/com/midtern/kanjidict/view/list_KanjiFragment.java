package com.midtern.kanjidict.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.midtern.kanjidict.R;
import com.midtern.kanjidict.model.B_Kanji;
import com.midtern.kanjidict.model.B_Kanji_Api;
import com.midtern.kanjidict.viewmodel.B_Kanji_Api_Service;
import com.midtern.kanjidict.viewmodel.KanjiAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class list_KanjiFragment extends Fragment {

    private B_Kanji_Api_Service b_Api;
    private ArrayList<B_Kanji> listKanji;
    private B_Kanji_Api b_kanji_api;
    private RecyclerView rv_listKanji;
    private KanjiAdapter kanjiAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list__kanji, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        rv_listKanji = view.findViewById(R.id.rv_list_kanji);
        listKanji = new ArrayList<B_Kanji>();
        kanjiAdapter = new KanjiAdapter(listKanji);
        rv_listKanji.setAdapter(kanjiAdapter);
        rv_listKanji.setLayoutManager(new GridLayoutManager(getContext(),4));
        b_Api = new B_Kanji_Api_Service();


        b_Api.get_B_Kanji("N5")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<B_Kanji>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<B_Kanji> list_b_kanji) {
                        Log.d("DEBUG","Succes");

                        for(B_Kanji dog :list_b_kanji){
                            //Log.d("DEBUG", "onSuccess: "+dog.getKanji());
                            listKanji.add(dog);
                            kanjiAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d("DEBUG","Fail"+e.getMessage());

                    }
                });
    }
}
/*
rv_listKanji = view.findViewById(R.id.rv_list_kanji);
        listKanji = new ArrayList<B_Kanji>();
        kanjiAdapter = new KanjiAdapter(listKanji);
        rv_listKanji.setAdapter(kanjiAdapter);
        rv_listKanji.setLayoutManager(new GridLayoutManager(getContext(),4));
        b_Api = new B_Kanji_Api_Service();


                b_Api.get_B_Kanji("N5")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<B_Kanji>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<B_Kanji> list_b_kanji) {
                        Log.d("DEBUG","Succes");

                        for(B_Kanji dog :list_b_kanji){
                            //Log.d("DEBUG", "onSuccess: "+dog.getKanji());
                            list_b_kanji.add(dog);
                            kanjiAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d("DEBUG","Fail"+e.getMessage());

                    }
                });
 */