package com.rentpassing.androidarchitecture.mvp;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rentpassing.androidarchitecture.R;
import com.rentpassing.androidarchitecture.databinding.ActivityMvpBinding;
import com.rentpassing.androidarchitecture.mvvm.MVVMActivity;

import java.util.ArrayList;
import java.util.List;


public class MVPActivity extends AppCompatActivity implements  CountryPresenter.View{
    ActivityMvpBinding binding;
    ListView countryListVIew;
    ArrayAdapter<String> listAdapter;
    List<String> countryList = new ArrayList<>();
    CountryPresenter countryPresenter;
    Button reFreshButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMvpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("MVP Architecture");
        countryPresenter = new CountryPresenter(this);

        reFreshButton = binding.mvcRefreshButton;
        countryListVIew = binding.countryListView;


        listAdapter = new ArrayAdapter<>(this, R.layout.list_view_item,R.id.countryTextView,countryList);
        countryListVIew.setAdapter(listAdapter);
        countryListVIew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MVPActivity.this, "You clicked " + countryList.get(position), Toast.LENGTH_SHORT).show();
            }
        });


        reFreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryPresenter.onRefresh();
            }
        });

    }

    @Override
    public void setValues(List<String> countryNames) {
        reFreshButton.setVisibility(View.GONE);
        countryListVIew.setVisibility(View.VISIBLE);
        countryList.clear();
        countryList.addAll(countryNames);
        Log.i("CountryNames",countryNames.get(0));
        listAdapter.notifyDataSetChanged();

    }

    @Override
    public void handleError() {
        countryListVIew.setVisibility(View.GONE);
        reFreshButton.setVisibility(View.VISIBLE);
    }
}
