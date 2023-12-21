package com.midtern.kanjidict.model;

import com.google.gson.annotations.SerializedName;

public class B_Kanji {
    @SerializedName("kanji")
    private String kanji;
    @SerializedName("vocabulary")
    private String vocabulary;
    @SerializedName("mean")
    private String mean;
    @SerializedName("id")
    private int id;

    public B_Kanji(String kanji, String vocabulary, String mean, int id) {
        this.kanji = kanji;
        this.vocabulary = vocabulary;
        this.mean = mean;
        this.id = id;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
