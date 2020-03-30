package com.dekikurnia.belajarmvvm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.dekikurnia.belajarmvvm.adapter.CoronaDataAdapter;
import com.dekikurnia.belajarmvvm.databinding.ActivityMainBinding;
import com.dekikurnia.belajarmvvm.model.Corona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;
    SwipeRefreshLayout swipeRefresh;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        initializationViews();
        getAllCorona();

        swipeRefresh.setOnRefreshListener(this::getAllCorona);
    }

    private void initializationViews() {
        swipeRefresh = findViewById(R.id.swipeRefresh);
        mRecyclerView = findViewById(R.id.viewCorona);
    }

    private void getAllCorona() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getAllCorona().observe(this, new Observer<List<Corona>>() {
            @Override
            public void onChanged(@Nullable List<Corona> coronaList) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(coronaList);
            }
        });
    }

    private void prepareRecyclerView(List<Corona> coronaList) {
        CoronaDataAdapter coronaDataAdapter = new CoronaDataAdapter(coronaList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(coronaDataAdapter);
        coronaDataAdapter.setCoronaList((ArrayList<Corona>) coronaList);
    }
}
