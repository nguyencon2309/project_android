package com.midtern.kanjidict.viewmodel;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.midtern.kanjidict.R;
import com.midtern.kanjidict.model.B_Kanji;
import com.midtern.kanjidict.view.detail_Kanji_Fragment;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;

public class KanjiAdapter extends RecyclerView.Adapter<KanjiAdapter.ViewHolder>  {
    public static ArrayList<B_Kanji> list_Kanji;

    public KanjiAdapter(ArrayList<B_Kanji> list_Kanji){
        this.list_Kanji = list_Kanji;
    }

    @NonNull
    @Override
    public KanjiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kanji, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull KanjiAdapter.ViewHolder holder, int position) {
        holder.tv_kanji.setText(list_Kanji.get(position).getKanji());
        holder.tv_vocabulary.setText(list_Kanji.get(position).getVocabulary());
    }

    @Override
    public int getItemCount() {
        return list_Kanji.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_kanji,tv_vocabulary;

        public ViewHolder(View view){
            super(view);
            tv_kanji = (view).findViewById(R.id.tv_kanji);
            tv_vocabulary = (view).findViewById(R.id.tv_vocabulary);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int a = list_Kanji.get(getAdapterPosition()).getId();
                    Log.d("DEBid","id"+a);
                    Bundle bundle = new Bundle();
                    bundle.putString("id", ""+a);
                    Navigation.findNavController(view).navigate(R.id.detail_Kanji_Fragment, bundle);

                }
            });
        }

    }

}

/*
public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {
    private ArrayList<DogBreed> dogBreedArrayList;

    public DogsAdapter(ArrayList<DogBreed> dogBreedList){
        this.dogBreedArrayList = dogBreedList;
    }

    @NonNull
    @Override
    public DogsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_item, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DogsAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(dogBreedArrayList.get(position).getName());
        holder.tv_origin.setText(dogBreedArrayList.get(position).getOrigin());
    }

    @Override
    public int getItemCount() {
        return dogBreedArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public TextView tv_name,tv_origin;
        public ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_origin = (TextView) view.findViewById(R.id.tv_origin);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }


    }



}
 */
