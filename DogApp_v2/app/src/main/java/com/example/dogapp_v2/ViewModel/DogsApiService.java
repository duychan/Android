package com.example.dogapp_v2.ViewModel;

import com.example.dogapp_v2.Model.DogAPI;
import com.example.dogapp_v2.Model.DogBreed;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogsApiService {
    private DogAPI dogAPI;

    public DogsApiService(){
        dogAPI = new Retrofit.Builder()
                .baseUrl(dogAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(DogAPI.class);
    }
    public Single<List<DogBreed>> getDogs(){
        return dogAPI.getDogs();
    }
}
