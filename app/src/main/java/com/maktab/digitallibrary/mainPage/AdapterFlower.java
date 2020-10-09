package com.maktab.digitallibrary.mainPage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.maktab.digitallibrary.R;
import com.maktab.digitallibrary.innerPage.ActivityInnerPage;

public class AdapterFlower extends RecyclerView.Adapter<ViewHolder> {
    @NonNull
    Context context;
    LayoutInflater inflater;
    TextView title;
    ImageView avatar;
    LinearLayout cardAdapter;

    public AdapterFlower(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_card_view, parent, false);
        title = view.findViewById(R.id.listTtile);
        avatar = view.findViewById(R.id.avetar);
        cardAdapter=view.findViewById(R.id.card_adapter);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(MainActivity.flower.get(position).getTitle());
        String imgAddress = MainActivity.flower.get(position).getImgAddress();
        int id = MainActivity.context.getResources().getIdentifier(imgAddress, "drawable", MainActivity.context.getPackageName());
        holder.avatar.setImageResource(id);
        holder.cardAdapter.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.context, ActivityInnerPage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            MainActivity.context.startActivity(intent);
        }
    };

        @Override
        public int getItemCount () {
            return MainActivity.flower.size();
        }
    }
