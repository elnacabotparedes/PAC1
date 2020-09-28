package com.elnacabot.pac1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.elnacabot.pac1.model.BookItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final static int EVEN = 0;
    private final static int ODD = 1;

    private List<BookItem> items;
    private boolean tablet;

    public MyAdapter(List<BookItem> items, Boolean tablet) {
        this.items = items;
        this.tablet = tablet;
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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position)
    {

        holder.title.setText(items.get(position).title);
        holder.author.setText(items.get(position).author);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dateTime = dateFormat.format(items.get(position).date_publish);


                if(!tablet)
                {
                    //Mobile
                    Intent intent = new Intent(holder.itemView.getContext(), BookDetailActivity.class);
                    intent.putExtra("id", String.valueOf(position+1));
                    intent.putExtra("title", items.get(position).title);
                    intent.putExtra("author", items.get(position).author);
                    intent.putExtra("date", dateTime);

                    intent.putExtra("description", items.get(position).description);
                    holder.itemView.getContext().startActivity(intent);
                }
                else
                {
                    //Tablet
                    BookDetailFragment detailFragment = new BookDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", String.valueOf(position+1));
                    bundle.putString("title", items.get(position).title);
                    bundle.putString("author", items.get(position).author);
                    bundle.putString("date", dateTime);
                    detailFragment.setArguments(bundle);
                    ((AppCompatActivity) holder.itemView.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, detailFragment).commit();
                }
            }
        });

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
        public FrameLayout frame;

        public MyViewHolder(@NonNull View root) {
            super(root);

            title = root.findViewById(R.id.title);
            author = root.findViewById(R.id.author);
        }
    }
}
