package com.example.dogapp_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.dogapp_v2.Model.DogBreed;
import com.example.dogapp_v2.ViewModel.DogsAdapter;
import com.example.dogapp_v2.ViewModel.DogsApiService;
import com.example.dogapp_v2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private DogsAdapter dogsAdapter;
    private ArrayList<DogBreed> dogBreeds;
    private DogsApiService dogsApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}