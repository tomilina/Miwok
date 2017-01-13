package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
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
        words.add(new Word("отец","әpә",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("мать","әṭa",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("сын","angsi",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("дочь","tune",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("старший брат","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("младший брат","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("старшая сестра","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("младшая сестра","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("бабушка","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("дедушка","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter (this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, words.get(position).getmAudioResourceId());
                mMediaPlayer.start();
                //                Очищаем память занимамую объектами медиа плеера при наступлении события окончания проигрывания файла
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
