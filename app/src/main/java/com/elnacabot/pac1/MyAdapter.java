package com.elnacabot.pac1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elnacabot.pac1.model.BookItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final static int EVEN = 0;
    private final static int ODD = 1;

    private List<BookItem> items;

    public MyAdapter(List<BookItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = null;

        if( viewType == EVEN)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pair_layout, parent, false);
            return new MyViewHolder(view);
        }

        if( viewType == ODD)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.odd_layout, parent, false);
        }
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {

        holder.title.setText(items.get(position).title);
        holder.author.setText(items.get(position).author);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {

        int type;

        if( position == 0 ) {
            type = ODD;
        }
        else
        {
            type = EVEN;
        }

        return type;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView title;
        public TextView author;

        public MyViewHolder(@NonNull View root) {
            super(root);

            title = root.findViewById(R.id.title);
            author = root.findViewById(R.id.author);

        }
    }
}