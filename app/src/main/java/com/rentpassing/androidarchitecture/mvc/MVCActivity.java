package com.rentpassing.androidarchitecture.mvc;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rentpassing.androidarchitecture.databinding.ActivityMvcBinding;

public class MVCActivity extends AppCompatActivity {
    ActivityMvcBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMvcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("MVC Architecture");

    }
}
