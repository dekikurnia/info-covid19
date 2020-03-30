package com.dekikurnia.belajarmvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dekikurnia.belajarmvvm.model.Corona;
import com.dekikurnia.belajarmvvm.model.CoronaRepository;

import java.util.List;

public class MainViewModel  extends AndroidViewModel {

    private CoronaRepository coronaRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        coronaRepository = new CoronaRepository();
    }
    public LiveData<List<Corona>> getAllCorona() {
        return coronaRepository.getMutableLiveData();
    }
}
