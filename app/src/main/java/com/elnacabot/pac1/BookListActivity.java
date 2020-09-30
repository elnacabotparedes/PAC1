package com.elnacabot.pac1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<BookItem> list;

    private StaggeredGridLayoutManager manager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        //Control if fragment exist in the view
        FrameLayout frame = findViewById(R.id.frame);
        Boolean tablet = false;
        //Fragment exist => Tablet / If not => Mobile
        if(frame != null)
        {
            tablet = true;
        }

        //Recover the list of books
        BookModel bookModel = new BookModel();
        list = bookModel.getItems();

        //Prepare the recycle
        recyclerView = findViewById(R.id.listElements);

        if(tablet == true)
        {
            //If its the table use the Layout Manager
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            mAdapter = new MyAdapter(list, tablet);
            recyclerView.setAdapter(mAdapter);
        }
        else
        {
            //If its a mobile use the StaggeredGridManager in order to obtain 2 columns
            manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
            mAdapter = new MyAdapter(list, tablet);
            recyclerView.setAdapter(mAdapter);
        }

    }

    //Sort the list of elements by title
    private void SortByTitle()
    {
        Collections.sort(list, new Comparator<BookItem>() {
            @Override
            public int compare(BookItem item1, BookItem item2) {
                return item1.getTitle().compareTo(item2.getTitle());
            }
        });
        mAdapter.notifyDataSetChanged();
    }

    //Sort the list of elements by author
    private void SortByAuthor()
    {
        Collections.sort(list, new Comparator<BookItem>() {
            @Override
            public int compare(BookItem item1, BookItem item2) {
                return item1.getAuthor().compareTo(item2.getAuthor());
            }
        });
        mAdapter.notifyDataSetChanged();
    }

    //Charge the menu in the view
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Control which option of the menu is selected and sort the adapter
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.sortTitle:
                SortByTitle();
                return true;
            case R.id.sortAuthor:
                SortByAuthor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}