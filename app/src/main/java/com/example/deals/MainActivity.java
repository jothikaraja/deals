package com.example.deals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT="com.example.deals.EXTRA_TEXT";
    public static final String EXTRA_TEXT1="com.example.deals.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2="com.example.deals.EXTRA_TEXT2";
    public static final String EXTRA_TEXT3="com.example.deals.EXTRA_TEXT3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Search=(Button)findViewById(R.id.search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                passtoresult();
            }
        });

    }
    public void passtoresult(){
        Intent intent=new Intent(this,result.class);
        EditText Product=(EditText)findViewById(R.id.product);
        String product=Product.getText().toString();
        EditText Brand=(EditText)findViewById(R.id.brand);
        String brand=Brand.getText().toString();
        EditText Pstart=(EditText)findViewById(R.id.pstart);
        String pstart=Pstart.getText().toString();
        EditText Pend=(EditText)findViewById(R.id.pend);
        String pend=Pend.getText().toString();
        intent.putExtra(EXTRA_TEXT,product);
        intent.putExtra(EXTRA_TEXT1,brand);
        intent.putExtra(EXTRA_TEXT2,pstart);
        intent.putExtra(EXTRA_TEXT3,pend);
        startActivity(intent);

    }
}
