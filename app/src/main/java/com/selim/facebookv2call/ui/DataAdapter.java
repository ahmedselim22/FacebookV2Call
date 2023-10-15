package com.selim.facebookv2call.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.selim.facebookv2call.R;
import com.selim.facebookv2call.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    List<DataItem> dataArrayList = new ArrayList<>();

//    public DataAdapter(ArrayList<Data> dataArrayList) {
//        this.dataArrayList = dataArrayList;
//    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.data_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        DataItem data=dataArrayList.get(position);
        holder.tv_id.setText(data.getId()+"");
        holder.tv_userId.setText(data.getUserId()+"");
        holder.tv_title.setText(data.getTitle());
        holder.tv_body.setText(data.getBody());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder{
        TextView tv_id,tv_userId ,tv_body ,tv_title;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id=itemView.findViewById(R.id.tv_id);
            tv_userId=itemView.findViewById(R.id.tv_userId);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_body=itemView.findViewById(R.id.tv_body);
        }
    }

    public void setList(ArrayList<DataItem> data){
        this.dataArrayList=data;
        notifyDataSetChanged();
    }
}
