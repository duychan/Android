package com.example.dogapp_v2.Model;


import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface DogAPI {
    String BASE_URL = "https://raw.githubusercontent.com";
    @GET("/DevTides/DogsApi/master/dogs.json")
    Single<List<DogBreed>> getDogs();
}
