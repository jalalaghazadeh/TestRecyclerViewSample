package com.mrjalal.testrecyclerviewsample;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 1/24/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<SimpleModel> simpleModelList = new ArrayList<>();

    public Adapter(List<SimpleModel> simpleModelList) {
        this.simpleModelList = simpleModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SimpleModel simpleModel = simpleModelList.get(position);
        holder.onBind(simpleModel);
    }

    @Override
    public int getItemCount() {
        return simpleModelList.size();
    }

    public void addItems(List<SimpleModel> newItemList){
        simpleModelList.addAll(newItemList);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv;
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv = itemView.findViewById(R.id.tv);
        }

        void onBind(SimpleModel simpleModel) {
            tv.setText(simpleModel.getText());
            tv.setBackgroundColor(simpleModel.getItemColor());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "u are Clicked", Toast.LENGTH_SHORT).show();
        }
    }

}
