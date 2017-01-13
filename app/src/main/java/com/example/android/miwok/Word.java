package com.example.android.miwok;

/**
 * Created by user on 11.01.17.
 */

public class Word {

    private String mMivokTranslation;
    private String mdefaultTranslation;
//    сохраняем только id картинки
    private int mImageResourceId = NO_IMAGE_PROVIDED;
//    id аудиофайла
    private int mAudioResourceId = NO_AUDIO_PROVIDED;

//    для проверки
    private static final int NO_IMAGE_PROVIDED = -1;
    private static final int NO_AUDIO_PROVIDED = -1;

    public Word(String mivokWord, String defaultWord){
        mMivokTranslation = mivokWord;
        mdefaultTranslation = defaultWord;
    }

    public Word(String mivokWord, String defaultWord, int audioResourceId){
        mMivokTranslation = mivokWord;
        mdefaultTranslation = defaultWord;
        mAudioResourceId = audioResourceId;
    }

    public Word(String mivokWord, String defaultWord, int imageResouceId, int audioResourceId){
        mMivokTranslation = mivokWord;
        mdefaultTranslation = defaultWord;
        mImageResourceId = imageResouceId;
        mAudioResourceId = audioResourceId;
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

    public int getmResourseImageId() {return mImageResourceId;}

    public int getmAudioResourceId() {return mAudioResourceId;}

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public boolean hasAudio(){
        return mAudioResourceId != NO_AUDIO_PROVIDED;
    }
}
