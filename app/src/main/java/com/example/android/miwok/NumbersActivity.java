package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Words array
        ArrayList<Word> words = new ArrayList<Word>();

//       create object inline and add new object to ArrayList
        words.add(new Word("один","lutti"));
        words.add(new Word("два","otiiko"));
        words.add(new Word("три","tolookosu"));
        words.add(new Word("четыре","oyyisa"));
        words.add(new Word("пять","massokka"));
        words.add(new Word("шесть","temmokka"));
        words.add(new Word("семь","tenekaku"));
        words.add(new Word("восемь","kawinta"));
        words.add(new Word("девять","wo'e"));
        words.add(new Word("десять","na'aacha"));

//        ArrayList<String> words = new ArrayList<String>();
//        words.add("one");
//        words.add("two");
//        words.add("three");
//        words.add("four");
//        words.add("five");
//        words.add("six");
//        words.add("seven");
//        words.add("eight");
//        words.add("nine");
//        words.add("ten");

        //        создаем адаптер
//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.list_item, words);
//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);
        WordAdapter adapter = new WordAdapter (this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

////        Получаем линеар лайоут по id
//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
//
//        for(int index = 0; index<10; index++){
//            //        создаем textView элемент
//            TextView wordView = new TextView(this);
//            //        устанавливаем значение текста
//            wordView.setText(words.get(index));
//            //        добавляем вьюшку в полученный лейаут
//            rootView.addView(wordView);
//        }


//        Log.v("NumberActivity", "Word at index 0: " + words.get(0));
//        Log.v("NumberActivity", "Word at index 1: " + words.get(1));
    }
}
