package com.drondon.android16;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {

    private static MutableLiveData<Data> liveData;

    public void set(Data data) {
        liveData.setValue(data);
    }

    public LiveData<Data> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();

        }
        return liveData;
    }

}
