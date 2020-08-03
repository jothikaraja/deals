package com.example.deals;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class cardadapter extends RecyclerView.Adapter<cardadapter.cardviewholder>{

    private Context mctx;
    private List<card> productList;
    public static final String EXTRA_TEXT="com.example.deals.EXTRA_TEXT";

    public cardadapter(Context mctx) {
        this.mctx = mctx;
        this.productList = new ArrayList<>();
    }

    @NonNull
    @Override
    public cardviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mctx);
        View view=inflater.inflate(R.layout.list,null);
        cardviewholder holder=new cardviewholder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull cardviewholder holder, int position) {

        final card Card=productList.get(position);
        holder.textView.setText(Card.getProduct_name());
        holder.textViewp.setText(Card.getPrice());
        Picasso.get().load(Card.getImage()).into(holder.imageView);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent=new Intent(v.getContext(),retail.class);
                    intent.putExtra(EXTRA_TEXT,Card.getButton());
                    v.getContext().startActivity(intent);


            }
        });
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    class cardviewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView,textViewp;
        Button btn;
        public cardviewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.product_name);
            textViewp=itemView.findViewById(R.id.price);
            btn=itemView.findViewById(R.id.view);

        }
    }
    public void setData(List<card> productList){
        this.productList=productList;
        notifyDataSetChanged();
    }

}
