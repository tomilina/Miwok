package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Words array
        ArrayList<Word> words = new ArrayList<Word>();

//       create object inline and add new object to ArrayList
        words.add(new Word("красный","weṭeṭṭi"));
        words.add(new Word("зеленый","chokokki"));
        words.add(new Word("коричневый","ṭakaakki"));
        words.add(new Word("серый","ṭopoppi"));
        words.add(new Word("черный","kululli"));
        words.add(new Word("белый","kelelli"));
        words.add(new Word("желтый","ṭopiisә"));
        words.add(new Word("горчичный","chiwiiṭә"));

        WordAdapter adapter = new WordAdapter (this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
