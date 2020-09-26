package com.elnacabot.pac1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Intent i = getIntent();
        String id = i.getStringExtra("id");

        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(id));
        BookDetailFragment detailFragment = new BookDetailFragment();
        detailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, detailFragment).commit();

    }
}