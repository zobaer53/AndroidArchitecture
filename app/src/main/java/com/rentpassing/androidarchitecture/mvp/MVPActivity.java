package com.rentpassing.androidarchitecture.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rentpassing.androidarchitecture.databinding.ActivityMvpBinding;

public class MVPActivity extends AppCompatActivity {
    ActivityMvpBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMvpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("MVP Architecture");
    }
}
