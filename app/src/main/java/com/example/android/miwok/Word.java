package com.example.android.miwok;

/**
 * Created by user on 11.01.17.
 */

public class Word {

    private String mMivokTranslation;
    private String mdefaultTranslation;

    public Word(String mivokWord, String defaultWord){
        mMivokTranslation = mivokWord;
        mdefaultTranslation = defaultWord;
    }
//
//    public void setMivokWord(String mivokWord){
//        mMivokTranslation = mivokWord;
//    }
//
//    public void setDefaultWord(String defaultWord){
//        mdefaultTranslation = defaultWord;
//    }

    public String getMivokWord() {
        return mMivokTranslation;
    }

    public String getDefaultWord() {
        return mdefaultTranslation;
    }
}
