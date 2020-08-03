package com.example.deals;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class detailadapter extends RecyclerView.Adapter<detailadapter.detailviewholder>{

    private Context context;
    private List<detail> detailList;


    public detailadapter(Context context, List<detail> detailList) {
        this.context = context;
        this.detailList=detailList;
    }

    @NonNull
    @Override
    public detailviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.product,null);
        detailviewholder holder=new detailviewholder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull detailviewholder holder, int position) {

        final detail d = detailList.get(position);
        holder.textView.setText(d.getProduct_store());
        holder.textViewp.setText(d.getProduct_price());
        Picasso.get().load(d.getProduct_store_logo()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    class detailviewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView,textViewp;

        public detailviewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.logo);
            textView=itemView.findViewById(R.id.product_store);
            textViewp=itemView.findViewById(R.id.product_price);
        }
    }
    public void setData(List<detail> detailList){
        this.detailList=detailList;
        notifyDataSetChanged();
    }
}
