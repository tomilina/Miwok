package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Words array
        ArrayList<Word> words = new ArrayList<Word>();

//       create object inline and add new object to ArrayList
        words.add(new Word("отец","әpә"));
        words.add(new Word("мать","әṭa"));
        words.add(new Word("сын","angsi"));
        words.add(new Word("дочь","tune"));
        words.add(new Word("старший брат","taachi"));
        words.add(new Word("младший брвт","chalitti"));
        words.add(new Word("старшая сестра","teṭe"));
        words.add(new Word("младшая сестра","kolliti"));
        words.add(new Word("бабушка","ama"));
        words.add(new Word("дедушка","paapa"));

        WordAdapter adapter = new WordAdapter (this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
