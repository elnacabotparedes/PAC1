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


        //Recover the information of the item selected
        Intent i = getIntent();
        String id = i.getStringExtra("id");

        //Pass the information to the fragment in order to be shown
        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(id));
        bundle.putString("author", i.getStringExtra("author"));
        bundle.putString("description", i.getStringExtra("description"));
        bundle.putString("date", i.getStringExtra("date"));
        bundle.putString("image", i.getStringExtra("image"));
        BookDetailFragment detailFragment = new BookDetailFragment();
        detailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, detailFragment).commit();

        //Add title to toolbar
        toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(i.getStringExtra("title"));

    }
}