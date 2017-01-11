package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Words array
        ArrayList<Word> words = new ArrayList<Word>();

//       create object inline and add new object to ArrayList
        words.add(new Word("Куда ты идешь?","minto wuksus"));
        words.add(new Word("Как тебя зовут?","tinnә oyaase'nә"));
        words.add(new Word("Меня зовут...","oyaaset..."));
        words.add(new Word("Как дела?","michәksәs?"));
        words.add(new Word("У меня все хорошо","kuchi achit"));
        words.add(new Word("Ты придешь?","әәnәs'aa?"));
        words.add(new Word("Да, приду","hәә’ әәnәm"));
        words.add(new Word("Уже иду","әәnәm"));
        words.add(new Word("Идем! (давай)","yoowutis"));
        words.add(new Word("Иди сюда","әnni'nem"));

        WordAdapter adapter = new WordAdapter (this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
