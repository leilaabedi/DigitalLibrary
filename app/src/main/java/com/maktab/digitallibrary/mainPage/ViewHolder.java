package com.maktab.digitallibrary.mainPage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maktab.digitallibrary.R;

public class ViewHolder extends RecyclerView.ViewHolder {
   public ImageView avatar;
   public TextView title;
   public LinearLayout cardAdapter;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        avatar=itemView.findViewById(R.id.avetar);
        title=itemView.findViewById(R.id.listTtile);
        cardAdapter=itemView.findViewById(R.id.card_adapter);



    }
}
