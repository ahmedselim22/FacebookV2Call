package com.selim.facebookv2call.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.selim.facebookv2call.R;
import com.selim.facebookv2call.model.DataItem;
import com.selim.facebookv2call.ui.DataAdapter;
import com.selim.facebookv2call.ui.DataViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    DataViewModel dataViewModel;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataAdapter dataAdapter = new DataAdapter();

        recyclerView=findViewById(R.id.recyclerview);


        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getDataFromDatabase();

        dataViewModel.listMutableLiveData.observe(this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                dataAdapter.setList((ArrayList<DataItem>) dataItems);
            }
        });
    }
}