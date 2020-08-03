package com.example.deals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;

public class retail extends AppCompatActivity {

    private static final int[] idarray={R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.button11,R.id.button12,R.id.button13,R.id.button14,R.id.button15,R.id.button16,R.id.button17};
    private ImageButton[] btn=new ImageButton[idarray.length];
    public String product_id;
    public String url;
    List<String> uurl;
    public List<detail> llist;
    private RequestQueue mrequestqueue;
    ImageView imageView;
    //public RecyclerView recyclerView;
    //public RecyclerView.Adapter adapter;
    //public detailadapter Detailaadapter;
    TextView textView;
    String content="";

    public static String durl;
    Intent viewIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retail);
        textView=findViewById(R.id.text1);
        /*recyclerView=findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/

        for(int i=0;i<idarray.length;i++) {
            btn[i] = (ImageButton) findViewById(idarray[i]);
            btn[i].setVisibility(View.GONE);
        }
        Intent intent = getIntent();
        product_id = intent.getStringExtra(cardadapter.EXTRA_TEXT);
        llist = new ArrayList<>();
        llist.add(new detail("uytrs","https:\\/\\/images-api.datayuge.in\\/image\\/ZmxpcGthcnRfc3RvcmUucG5n.png","567890","https:\\/\\/images-api.datayuge.in\\/image\\/ZmxpcGthcnRfc3RvcmUucG5n.png"));

        mrequestqueue=Volley.newRequestQueue(this);

        url="https://price-api.datayuge.com/api/v1/compare/detail"+"?api_key="+BuildConfig.api_key+"&id="+product_id;

        durl=loadrecyclerviewdata();

       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                durl=loadrecyclerviewdata();
                Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_LONG).show();
                viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse(durl));
                startActivity(viewIntent);
            }
        });*/


        //textView.append(textView.getText().toString());
        //Detailaadapter =new detailadapter(getApplicationContext(),llist);
        //recyclerView.setAdapter(Detailaadapter);




    }
    public String loadrecyclerviewdata(){


        RequestQueue queue=Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            try {

                List<String> store=new ArrayList<>();
                store.add("amazon");
                store.add("flipkart");
                store.add("snapdeal");
                store.add("ebay");
                store.add("paytm");
                store.add("croma");
                store.add("yebhi");
                store.add("indiatimes");
                store.add("homeshop18");
                store.add("naaptol");
                store.add("infibeam");
                store.add("tatacliq");
                store.add("shopclues");
                store.add("paytmmall");
                store.add("gadgets360");
                store.add("mi");
                store.add("2gud");


                JSONObject JO = new JSONObject(response);
                JSONObject J = JO.getJSONObject("data");
                final JSONArray JA = J.getJSONArray("stores");
                uurl=new ArrayList<>();
                String image;
                if(J.getBoolean("is_available")==true) {
                    for (int j = 0; j < 17; j++) {
                        content = "";
                        try {
                            JSONObject J1 = JA.getJSONObject(j).getJSONObject(store.get(j));

                            content += "\nproduct_store:" + J1.getString("product_store") + "\nproduct_price:" + J1.getString("product_price");
                            image = J1.getString("product_store_logo");
                            uurl.add(J1.getString("product_store_url"));

                            textView.append(content);
                            btn[j].setVisibility(View.VISIBLE);
                            Picasso.get().load(image).into(btn[j]);


                            btn[j].setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    switch (v.getId()) {
                                        case R.id.button1:
                                            viewIntent =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(0)));
                                            startActivity(viewIntent);
                                            break;
                                        case R.id.button2:
                                            Intent viewIntent2 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(1)));
                                            startActivity(viewIntent2);
                                            break;
                                        case R.id.button3:
                                            Intent viewIntent3 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(2)));
                                            startActivity(viewIntent3);
                                            break;
                                        case R.id.button4:
                                            Intent viewIntent4 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(3)));
                                            startActivity(viewIntent4);
                                            break;
                                        case R.id.button5:
                                            Intent viewIntent5 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(4)));
                                            startActivity(viewIntent5);
                                            break;
                                        case R.id.button6:
                                            Intent viewIntent6 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(5)));
                                            startActivity(viewIntent6);
                                            break;
                                        case R.id.button7:
                                            Intent viewIntent7 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(6)));
                                            startActivity(viewIntent7);
                                            break;

                                        case R.id.button8:
                                            Intent viewIntent8 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(7)));
                                            startActivity(viewIntent8);
                                            break;

                                        case R.id.button9:
                                            Intent viewIntent9 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(8)));
                                            startActivity(viewIntent9);
                                            break;

                                        case R.id.button10:
                                            Intent viewIntent10 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(9)));
                                            startActivity(viewIntent10);
                                            break;
                                        case R.id.button11:
                                            Intent viewIntent11 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(10)));
                                            startActivity(viewIntent11);
                                            break;
                                        case R.id.button12:
                                            Intent viewIntent12 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(11)));
                                            startActivity(viewIntent12);
                                            break;
                                        case R.id.button13:
                                            Intent viewIntent13 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(12)));
                                            startActivity(viewIntent13);
                                            break;
                                        case R.id.button14:
                                            Intent viewIntent14 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(13)));
                                            startActivity(viewIntent14);
                                            break;
                                        case R.id.button15:
                                            Intent viewIntent15 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(14)));
                                            startActivity(viewIntent15);
                                            break;
                                        case R.id.button16:
                                            Intent viewIntent16 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(15)));
                                            startActivity(viewIntent16);
                                            break;
                                        case R.id.button17:
                                            Intent viewIntent17 =
                                                    new Intent("android.intent.action.VIEW",
                                                            Uri.parse(uurl.get(16)));
                                            startActivity(viewIntent17);
                                            break;


                                    }

                                }
                            });
                        } catch (JSONException o) {
                            o.printStackTrace();
                        }

                    }
                }
                else{
                    textView.setText("sorry,\nthe product is currently unavailable");
                }

                //adapter=new detailadapter(getApplicationContext(),llist);
                //recyclerView.setAdapter(adapter);
                //Detailaadapter =new detailadapter(getApplicationContext(),llist);
                //recyclerView.setAdapter(Detailaadapter);

            }catch (JSONException e){
                e.printStackTrace();
            }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

      queue.add(stringRequest);
      return durl;

    }

    }

