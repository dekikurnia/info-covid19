package com.dekikurnia.belajarmvvm.network;

import com.dekikurnia.belajarmvvm.model.Corona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaDataService {
    @GET("indonesia/provinsi")
    Call<List<Corona>> getCorona();
}
