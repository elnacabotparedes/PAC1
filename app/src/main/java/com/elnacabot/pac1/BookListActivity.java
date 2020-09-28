package com.elnacabot.pac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.elnacabot.pac1.model.BookItem;
import com.elnacabot.pac1.model.BookModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    private FrameLayout frame;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private BookModel bookModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        recyclerView = findViewById(R.id.listElements);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        BookModel bookModel = new BookModel();

        FrameLayout frame = findViewById(R.id.frame);
        Boolean tablet = false;
        if(frame != null)
        {
            tablet = true;
        }

        mAdapter = new MyAdapter(bookModel.getItems(), tablet);

        recyclerView.setAdapter(mAdapter);


        /*
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
                    BookDetailFragment detailFragment = new BookDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", String.valueOf(i+1));
                    detailFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, detailFragment).commit();
                }
                else
                {
                    Intent intent = new Intent(BookListActivity.this, BookDetailActivity.class);
                    intent.putExtra("id", String.valueOf(i+1));
                    startActivity(intent);
                }

            }
        });*/




    }
}