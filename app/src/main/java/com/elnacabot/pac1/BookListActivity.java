package com.elnacabot.pac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
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

        //Create the list of items
        final String[] elements = new String[10];
        for(int i = 0; i < 10; i++)
        {
            elements[i] = (i+1)+ "   Item " + (i+1);
        }

        arrayList = new ArrayList<>(Arrays.asList(elements));

        //Create the adapter and insert the elements
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.book_detail, R.id.content, arrayList);

        list.setAdapter(arrayAdapter);

        //Control if item is selected in the list and print in the view
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Control if a fragment exist in the view to difference MOBILE - TABLET
                frame = findViewById(R.id.frame);
                if(frame != null)
                {
                    /*TABLET*/
                    BookDetailFragment detailFragment = new BookDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", String.valueOf(i+1));
                    detailFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, detailFragment).commit();
                }
                else
                {
                    /*MOBILE*/
                    Intent intent = new Intent(BookListActivity.this, BookDetailActivity.class);
                    intent.putExtra("id", String.valueOf(i+1));
                    startActivity(intent);
                }

            }
        });




    }
}