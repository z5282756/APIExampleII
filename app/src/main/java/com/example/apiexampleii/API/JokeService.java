package com.example.apiexampleii.API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeService {
    @GET("jokes/random")
    // calling object from the joke class; endpoint above just gets a random joke
    Call<Joke> getRandomJoke();
}
