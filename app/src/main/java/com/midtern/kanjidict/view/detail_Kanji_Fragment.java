package com.midtern.kanjidict.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.midtern.kanjidict.R;
import com.midtern.kanjidict.model.C_Kanji;
import com.midtern.kanjidict.model.Compound;
import com.midtern.kanjidict.viewmodel.C_Kanji_Api_Service;
import com.midtern.kanjidict.viewmodel.CompoundAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class detail_Kanji_Fragment extends Fragment {

    private C_Kanji_Api_Service c_Api;
    private CompoundAdapter cp_Adapter;
    private RecyclerView rv_cp;

    private ArrayList<Compound> list_compound;
    private TextView kanji,mean,vocabulary,onyomi,kunyomi;
    public String s;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
           s = getArguments().getString("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail__kanji_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int id = Integer.parseInt(s);
        kanji = view.findViewById(R.id.kanji);
        mean = view.findViewById(R.id.mean);
        vocabulary = view.findViewById(R.id.vocabulary);
        onyomi = view.findViewById(R.id.onyomi);
        kunyomi = view.findViewById(R.id.kunyomi);

        list_compound = new ArrayList<Compound>();

        cp_Adapter = new CompoundAdapter(list_compound);

        rv_cp = view.findViewById(R.id.list_compounds);
        rv_cp.setAdapter(cp_Adapter);
        rv_cp.setLayoutManager(new LinearLayoutManager(getContext()));



        c_Api = new C_Kanji_Api_Service();
        c_Api.get_C_Kanji(id)
                .enqueue(new Callback<C_Kanji>() {
                    @Override
                    public void onResponse(Call<C_Kanji> call, Response<C_Kanji> response) {
                        kanji.setText(response.body().getKanji());
                        mean.setText("Nghĩa : "+response.body().getMean());
                        vocabulary.setText("Hán Việt : "+response.body().getVocabulary());
                        onyomi.setText("Âm On : "+response.body().getOnyomi());
                        kunyomi.setText("Âm Kun : "+response.body().getKunyomi());
                        //Log.d("DEBUG_compound","success body"+response.body().getCompounds());

                        for(Compound cp:response.body().getCompounds()){
                            list_compound.add(cp);
                            cp_Adapter.notifyDataSetChanged();
                            Log.d("DEBUG_compound",""+cp.getCompound());
                        }

                    }

                    @Override
                    public void onFailure(Call<C_Kanji> call, Throwable t) {

                        Log.d("DEBUG1","fail"+t.getMessage());
                    }
                });
    }
}