package com.example.materialdesigndemo;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Asus on 2017/3/20.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    List<Person> mPersons;
    public MyAdapter(List<Person> mPersons){
        this.mPersons=mPersons;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView mCardView;
        ImageView mImageView;
        TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mCardView= (CardView) itemView.findViewById(R.id.cardView);
            mImageView= (ImageView) itemView.findViewById(R.id.image_head);
            mTextView= (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=viewHolder.getAdapterPosition();
                Person person=mPersons.get(position);
                Intent intent=new Intent(viewHolder.itemView.getContext(),BlogActivity.class);
                intent.putExtra(BlogActivity.NAME,person.getName());
                intent.putExtra(BlogActivity.NAME_ID,person.getHead());
                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person=mPersons.get(position);
        holder.mTextView.setText(person.getName());
        Glide.with(holder.itemView.getContext()).load(person.getHead()).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }
}
