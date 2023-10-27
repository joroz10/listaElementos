package com.example.listaelementos.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listaelementos.R;
import com.example.listaelementos.models.Creature;

import java.util.List;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataHolder> {
    @NonNull
    List<Creature> list;
    private View.OnClickListener listener;
    private OnItemClickListener itemListener;

    public RecyclerDataAdapter(List<Creature> list, OnItemClickListener listener){
        this.list = list;
        this.itemListener = listener;
    }

    @Override
    public RecyclerDataAdapter.RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, null, false);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDataAdapter.RecyclerDataHolder holder, int position) {
        holder.assignData(list.get(position), itemListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {

        TextView tw;
        ImageView img;
        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            tw = itemView.findViewById(R.id.txtNameMain);
            img = itemView.findViewById(R.id.imgRcvMain);
        }

        public void assignData(Creature p, OnItemClickListener onItemClickListener) {

            tw.setText(p.name);
            tw.setBackgroundColor(Color.parseColor("#"+p.colorNombre));
            img.setImageResource(p.drawable);
            itemView.setBackgroundColor(Color.parseColor("#"+p.colorImagen));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(p,getItemCount());
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Creature p, int position);
    }
}
