package com.elnacabot.pac1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class BookDetailFragment extends Fragment {

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

        //Recover the information from the item selected
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            //Print the information in the fragment
            TextView id = (TextView) view.findViewById(R.id.idItem);
            id.setText(bundle.getString("id", "example"));
        }
        return view;
    }

}