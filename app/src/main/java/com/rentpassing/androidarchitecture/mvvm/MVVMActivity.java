package com.rentpassing.androidarchitecture.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rentpassing.androidarchitecture.databinding.ActivityMvvmBinding;

public class MVVMActivity extends AppCompatActivity {
    ActivityMvvmBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMvvmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("MVVM Architecture");
    }
}
