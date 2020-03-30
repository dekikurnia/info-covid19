package com.dekikurnia.belajarmvvm.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.dekikurnia.belajarmvvm.network.CoronaDataService;
import com.dekikurnia.belajarmvvm.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronaRepository {
    private String TAG = "CoronaRepository";
    private MutableLiveData<List<Corona>> mutableLiveData = new MutableLiveData<>();

    public CoronaRepository() {
    }

    public MutableLiveData<List<Corona>> getMutableLiveData() {
        final CoronaDataService coronaDataService = RetrofitClient.getService();
        Call<List<Corona>> call = coronaDataService.getCorona();
        call.enqueue(new Callback<List<Corona>>() {

            @Override
            public void onResponse(Call<List<Corona>> call, Response<List<Corona>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());;
                }
            }

            @Override
            public void onFailure(Call<List<Corona>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getCause());
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                Log.e(TAG, "onFailure: " + t.getMessage());
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
        return mutableLiveData;
    }
}
