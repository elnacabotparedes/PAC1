package com.elnacabot.pac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elnacabot.pac1.model.BookItem;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final static int EVEN = 0;
    private final static int ODD = 1;

    private List<BookItem> items;  //Contain the book list
    private boolean tablet;        //In order to know if its table or mobile

    public MyAdapter(List<BookItem> items, Boolean tablet) {
        this.items = items;
        this.tablet = tablet;
    }

    //Charge the view
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = null;

        //If its a table have to combine if it's even or odd element in the list
        if( tablet == true)
        {
            if( viewType == EVEN)
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.even_layout, parent, false);
                return new MyViewHolder(view);
            }

            if( viewType == ODD)
            {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.odd_layout, parent, false);
            }
        }
        //If its a mobile have to charge the card with the size of the image
        else
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptative_elements, parent, false);
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position)
    {

        //Charge the title and the author name
        holder.title.setText(items.get(position).title);
        holder.author.setText(items.get(position).author);

        //If its a mobile also charge image in the cardview
        if(!tablet)
        {
            int id = ((AppCompatActivity) holder.itemView.getContext()).getResources().getIdentifier(items.get(position).url, "drawable",((AppCompatActivity) holder.itemView.getContext()).getPackageName());
            holder.imageView.setImageResource(id);
        }

        //Control if the element is click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Format for the date ( details )
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dateTime = dateFormat.format(items.get(position).date_publish);

                //Mobile view charge the bookDetailActivity
                if(!tablet)
                {
                    //Mobile
                    Intent intent = new Intent(holder.itemView.getContext(), BookDetailActivity.class);
                    intent.putExtra("id", String.valueOf(position+1));
                    intent.putExtra("title", items.get(position).title);
                    intent.putExtra("author", items.get(position).author);
                    intent.putExtra("date", dateTime);
                    intent.putExtra("description", items.get(position).description);
                    intent.putExtra("image", items.get(position).url);
                    intent.putExtra("description", items.get(position).description);
                    holder.itemView.getContext().startActivity(intent);
                }
                //Tablet charge the details to BookDetailFragment
                else
                {
                    //Tablet
                    BookDetailFragment detailFragment = new BookDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", String.valueOf(position+1));
                    bundle.putString("title", items.get(position).title);
                    bundle.putString("author", items.get(position).author);
                    bundle.putString("date", dateTime);
                    bundle.putString("description", items.get(position).description);
                    bundle.putString("image", items.get(position).url);
                    detailFragment.setArguments(bundle);
                    ((AppCompatActivity) holder.itemView.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, detailFragment).commit();
                }
            }
        });

    }


    //Return the number of elements of the list
    @Override
    public int getItemCount() {
        return items.size();
    }

    //Return if element is even or odd
    @Override
    public int getItemViewType(int position) {

        int type;

        if( (position % 2) == 0 ) {
            type = EVEN;
        }
        else
        {
            type = ODD;
        }

        return type;
    }


    //Prepare the viewholder with the elements of the view
    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView title;
        public TextView author;
        public ImageView imageView;

        public MyViewHolder(@NonNull View root) {
            super(root);

            title = root.findViewById(R.id.title);
            author = root.findViewById(R.id.author);
            imageView = root.findViewById(R.id.imageView);
        }
    }
}
