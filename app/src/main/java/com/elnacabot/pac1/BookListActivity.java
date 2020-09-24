package com.elnacabot.pac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class BookListActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        list = findViewById(R.id.listElements);

        final String[] elements = new String[10];
        for(int i = 0; i < 10; i++)
        {
            elements[i] = (i+1)+ "   Item " + (i+1);
        }

        arrayList = new ArrayList<>(Arrays.asList(elements));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.book_detail, R.id.content, arrayList);

        list.setAdapter(arrayAdapter);

        frame = findViewById(R.id.frame);
        if(frame == null)
        {
            Toast.makeText(this, "TABLET", Toast.LENGTH_SHORT).show();
        }
        else
        {
            BookDetailFragment bookdetails = new BookDetailFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame, bookdetails).commit();
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                frame = findViewById(R.id.frame);
                if(frame != null)
                {
                    /*TABLET*/
                    BookDetailFragment detailFragment = new BookDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", String.valueOf(i+1));
                    detailFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, detailFragment).commit();
                }
                else
                {
                    //Intent a BookDetailActivity
                }

            }
        });




    }
}