package com.elnacabot.pac1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class BookListActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        list = findViewById(R.id.listElements);

        String[] elements = new String[10];
        for(int i = 0; i < 10; i++)
        {
            elements[i] = (i+1)+ "   Item " + (i+1);
        }

        arrayList = new ArrayList<>(Arrays.asList(elements));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.book_detail, R.id.content, arrayList);

        list.setAdapter(arrayAdapter);


    }
}