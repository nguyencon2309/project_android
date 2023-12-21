package com.midtern.kanjidict.model;

import com.google.gson.annotations.SerializedName;

public class Compound {
    @SerializedName("compound")
    private String compound;
    @SerializedName("mean")
    private String mean;
    @SerializedName("hiragana")
    private String hiragana;
    @SerializedName("vocabulary")
    private String vocabulary;

    public Compound(String compound, String mean, String hiragana, String vocabulary) {
        this.compound = compound;
        this.mean = mean;
        this.hiragana = hiragana;
        this.vocabulary = vocabulary;
    }

    public String getCompound() {
        return compound;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }
}
