 package com.rentpassing.androidarchitecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rentpassing.androidarchitecture.databinding.ActivityArchitectureBinding;
import com.rentpassing.androidarchitecture.mvc.MVCActivity;
import com.rentpassing.androidarchitecture.mvp.MVPActivity;
import com.rentpassing.androidarchitecture.mvvm.MVVMActivity;

 public class ArchitectureActivity extends AppCompatActivity {

    ActivityArchitectureBinding binding;
    Button mvc,mvp,mvvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArchitectureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mvc = binding.buttonMVC;
        mvp = binding.buttonMVP;
        mvvm = binding.buttonMVVM;

        mvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArchitectureActivity.this, MVCActivity.class));

            }
        });
        mvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArchitectureActivity.this, MVPActivity.class));
            }
        });
        mvvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArchitectureActivity.this, MVVMActivity.class));
            }
        });
    }
}