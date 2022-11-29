package com.example.apiexampleii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity { 
    // add attributes
    Button mButton;
    TextView mJoke;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find the attributes and connect to XML (find the handle to the UI elements):
        mButton = findViewById(R.id.btnDisplayJoke);
        mJoke = findViewById(R.id.tvJoke);

        // set up retrofit to make API call
        // set up object from retrofit class and specify base URL and add
        // gson as the converterFactory:
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();




        //when click on button...
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mJoke.setText("random joke");
            }
        });
    }
}