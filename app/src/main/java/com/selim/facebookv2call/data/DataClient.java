package com.selim.facebookv2call.data;

import com.selim.facebookv2call.model.DataItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataClient {
    private DataInterface dataInterface;
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private static DataClient INSTANCE;

    public DataClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dataInterface = retrofit.create(DataInterface.class);
    }

    public static DataClient getInstance(){
        if (INSTANCE==null){
            INSTANCE = new DataClient();
        }
        return INSTANCE;
    }

    public Call<List<DataItem>> getData(){
        return dataInterface.getData();
    }

}
