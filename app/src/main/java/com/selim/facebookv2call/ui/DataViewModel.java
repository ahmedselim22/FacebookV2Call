package com.selim.facebookv2call.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.selim.facebookv2call.data.DataClient;
import com.selim.facebookv2call.model.DataItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {
    DataClient dataClient = DataClient.getInstance();
    MutableLiveData<List<DataItem>> listMutableLiveData = new MutableLiveData<>();

    public void getDataFromDatabase(){
        dataClient.getData().enqueue(new Callback<List<DataItem>>() {
            @Override
            public void onResponse(Call<List<DataItem>> call, Response<List<DataItem>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<DataItem>> call, Throwable t) {

            }
        });
    }

}
