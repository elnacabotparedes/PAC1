package com.elnacabot.pac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class BookDetailActivity extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Hide Status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_book_detail);

        //Custom top bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent i = getIntent();
        String id = i.getStringExtra("id");

        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(id));
        BookDetailFragment detailFragment = new BookDetailFragment();
        detailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, detailFragment).commit();

        toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("Item "+id);

    }
}