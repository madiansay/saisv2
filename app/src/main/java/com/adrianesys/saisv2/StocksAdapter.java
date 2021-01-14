package com.adrianesys.saisv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.ViewHolder> {

    ArrayList<String> samplestocks;

    public StocksAdapter(ArrayList<String> samplestocks) {
        this.samplestocks = samplestocks;
    }

    @NonNull
    @Override
    public StocksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_rows,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StocksAdapter.ViewHolder holder, int position) {
        holder.itemname.setText(samplestocks.get(position));
    }

    @Override
    public int getItemCount() {
        return samplestocks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemname = itemView.findViewById(R.id.itm_name);
        }
    }
}
