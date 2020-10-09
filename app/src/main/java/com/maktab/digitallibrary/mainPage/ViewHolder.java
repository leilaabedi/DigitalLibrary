package com.maktab.digitallibrary.mainPage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maktab.digitallibrary.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView avatar;
    TextView title;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        avatar=itemView.findViewById(R.id.avetar);
        title=itemView.findViewById(R.id.listTtile);



    }
}
