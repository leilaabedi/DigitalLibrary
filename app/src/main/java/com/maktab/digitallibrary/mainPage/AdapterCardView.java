package com.maktab.digitallibrary.mainPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.maktab.digitallibrary.R;

public class AdapterCardView extends RecyclerView.Adapter<ViewHolder> {
    @NonNull
    Context context;
    LayoutInflater inflater;

    public AdapterCardView(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=inflater.inflate(R.layout.adapter_card_view,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
