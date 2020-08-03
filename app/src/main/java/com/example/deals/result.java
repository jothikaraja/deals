package com.example.deals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class result extends AppCompatActivity {
    List<card> productList;
    private RecyclerView recyclerView;
    private cardadapter Cardadapter;
    private String content = "";
    private search S;
    private boolean res = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        recyclerView = findViewById(R.id.recyclerview);
        Intent intent = getIntent();
        final String api_key = BuildConfig.api_key;
        final String product = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        final String brand = intent.getStringExtra(MainActivity.EXTRA_TEXT1);
        final String price_start = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
        final String price_end = intent.getStringExtra(MainActivity.EXTRA_TEXT3);
        final String page = "1";

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Cardadapter = new cardadapter(this);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(Cardadapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://price-api.datayuge.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonplaceholderapi Jsonplaceholderapi = retrofit.create(jsonplaceholderapi.class);
        Call<search> call = Jsonplaceholderapi.getsearch("v1", api_key, product, brand, price_start, price_end, page);
        call.enqueue(new Callback<search>() {
            @Override
            public void onResponse(Call<search> call, Response<search> response) {
                if (!response.isSuccessful()) {
                    //textView.setText("code:" + response.code());
                    return;
                }
                S = response.body();
                List<card> llist = new ArrayList<>();
                for (pdata d : S.data) {
                   if( checkavail(d.getProduct_id())){
                    String lower = String.valueOf(d.getProduct_lowest_price());
                    llist.add(new card(d.getProduct_title(), "lowest price:" + lower, d.getProduct_image(), d.getProduct_id()));
                }
                }

                Cardadapter.setData(llist);


            }

            @Override
            public void onFailure(Call<search> call, Throwable t) {


                // textView.setText(t.getMessage());
            }


        });
    }



    public boolean checkavail(String id) {



        return res;
    }
    }

