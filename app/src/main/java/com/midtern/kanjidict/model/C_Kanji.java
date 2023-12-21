package com.midtern.kanjidict.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class C_Kanji {
    @SerializedName("kanji")
    private String kanji;
    @SerializedName("vocabulary")
    private String vocabulary;
    @SerializedName("mean")
    private String mean;
    @SerializedName("id")
    private int id;
    @SerializedName("onyomi")
    private String onyomi;
    @SerializedName("kunyomi")
    private String kunyomi;
    @SerializedName("compounds")
    private ArrayList<Compound> compounds;

    public C_Kanji(String kanji, String vocabulary, String mean, int id, String onyomi, String kunyomi, ArrayList<Compound> compounds) {
        this.kanji = kanji;
        this.vocabulary = vocabulary;
        this.mean = mean;
        this.id = id;
        this.onyomi = onyomi;
        this.kunyomi = kunyomi;
        this.compounds = compounds;
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

    public String getOnyomi() {
        return onyomi;
    }

    public void setOnyomi(String onyomi) {
        this.onyomi = onyomi;
    }

    public String getKunyomi() {
        return kunyomi;
    }

    public void setKunyomi(String kunyomi) {
        this.kunyomi = kunyomi;
    }

    public ArrayList<Compound> getCompounds() {
        return compounds;
    }

    public void setCompounds(ArrayList<Compound> compounds) {
        this.compounds = compounds;
    }
}
