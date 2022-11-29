package com.example.apiexampleii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.apiexampleii.API.Joke;
import com.example.apiexampleii.API.JokeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";

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
        // instantiate object from retrofit class and specify base URL and add
        // gson as the converterFactory:
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // instantiate an object from the JokeService class we added:
        JokeService service = retrofit.create(JokeService.class);
        // to be able to use that, we need to have implementation for the method we just added:


        //when click on button...
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Joke> responseCall = service.getRandomJoke();
                responseCall.enqueue(new Callback<Joke>() {
                    @Override
                    public void onResponse(Call<Joke> call, Response<Joke> response) {
                        Log.d(TAG, "API success");
                        Joke joke = response.body();
                        mJoke.setText(joke.getValue());

                    }

                    @Override
                    public void onFailure(Call<Joke> call, Throwable t) {
                        Log.d(TAG, "API failure");

                    }
                });
            }
        });
    }
}