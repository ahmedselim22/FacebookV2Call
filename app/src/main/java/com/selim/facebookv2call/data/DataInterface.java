package com.selim.facebookv2call.data;

import com.selim.facebookv2call.model.DataItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataInterface {
    @GET("/posts")
    public Call<List<DataItem>> getData();
}
