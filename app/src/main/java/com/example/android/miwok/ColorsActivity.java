package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
//для управления аудио фокусом
    private AudioManager am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
    private AudioManager.OnAudioFocusChangeListener afChangeListener;
//    Для реализации интерфейса отвечающего за отслеживание окончания проигрывания файла
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Words array
        final ArrayList<Word> words = new ArrayList<Word>();

//       create object inline and add new object to ArrayList
        words.add(new Word("красный","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("зеленый","chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("коричневый","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("серый","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("черный","kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("белый","kelelli",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("желтый","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("горчичный","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter (this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(words.get(position).hasAudio()){
//                    очищаем медиа плеер
                    releaseMediaPlayer();
//                    запрашиваем аудиофокус
                    // Request audio focus for playback
                    int result = am.requestAudioFocus(afChangeListener,
                            // Use the music stream.
                            AudioManager.STREAM_MUSIC,
                            // Request permanent focus.
                            AudioManager.AUDIOFOCUS_GAIN);

                    if (result == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT) {
                        // Start playback
                        mMediaPlayer = MediaPlayer.create(ColorsActivity.this, words.get(position).getmAudioResourceId());
                        mMediaPlayer.start();
                        //                Очищаем память занимамую объектами медиа плеера при наступлении события окончания проигрывания файла
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        // Abandon audio focus when playback complete
                        am.abandonAudioFocus(afChangeListener);
                    }
                }
                else{
                    Toast.makeText(ColorsActivity.this, "No audio file", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

//    если выходим из активити прекращаем воспроизводить звук
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
        // Abandon audio focus when playback complete
        am.abandonAudioFocus(afChangeListener);
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}
