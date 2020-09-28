package com.elnacabot.pac1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class BookDetailFragment extends Fragment {

    private ImageView imageBook;
    private TextView author;
    private TextView date;
    private TextView description;


    public BookDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the Fragment in the view
        View view = inflater.inflate(R.layout.fragment_book_detail, container, false);

        Init(view);

        //Recover the information from the item selected
        Bundle bundle = getArguments();
        if(bundle != null)
        {

            imageBook.setImageResource(R.drawable.book);
            author.setText(bundle.getString("author", "example"));
            date.setText(bundle.getString("date", "example"));
            description.setText(bundle.getString("description", "example"));

        }
        return view;
    }

    private void Init(View view)
    {
        imageBook = view.findViewById(R.id.imageBook);
        author = view.findViewById(R.id.author);
        date = view.findViewById(R.id.date);
        description = view.findViewById(R.id.description);
    }

}