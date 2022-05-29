package com.rentpassing.androidarchitecture.mvc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rentpassing.androidarchitecture.R;
import com.rentpassing.androidarchitecture.databinding.ActivityMvcBinding;
import com.rentpassing.androidarchitecture.model.Country;
import com.rentpassing.androidarchitecture.mvvm.MVVMActivity;

import java.util.ArrayList;
import java.util.List;

public class MVCActivity extends AppCompatActivity {
    ActivityMvcBinding binding;
    ListView countryListVIew;
    ArrayAdapter<String> listAdapter;
    List<String> countryList = new ArrayList<>();
    CountryController countryController;
    Button reFreshButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMvcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("MVC Architecture");

        countryController = new CountryController(this);

        reFreshButton = binding.mvcRefreshButton;
        countryListVIew = binding.countryListView;


        listAdapter = new ArrayAdapter<>(this, R.layout.list_view_item,R.id.countryTextView,countryList);
        countryListVIew.setAdapter(listAdapter);

        countryListVIew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MVCActivity.this, "You clicked " + countryList.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        reFreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryController.onRefresh();
            }
        });


    }
    public   void setValues(List<String> values){

        reFreshButton.setVisibility(View.GONE);
        countryListVIew.setVisibility(View.VISIBLE);
        countryList.clear();
        countryList.addAll(values);
       // Log.i("CountryNames",countryList.get(0));
        listAdapter.notifyDataSetChanged();

    }
    public void handleError(){
        countryListVIew.setVisibility(View.GONE);
        reFreshButton.setVisibility(View.VISIBLE);
    }
}
