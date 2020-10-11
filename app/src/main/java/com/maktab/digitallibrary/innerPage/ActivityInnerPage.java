package com.maktab.digitallibrary.innerPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.ImageReader;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.maktab.digitallibrary.R;
import com.maktab.digitallibrary.mainPage.MainActivity;

public class ActivityInnerPage extends AppCompatActivity {
    private int id;
    private String title;
    private String content;
    private String more;
    private String imageAddress;
    private int layoutId;
    private String pageName;

    private TextView contentDescription;
    private TextView moreDescriptin;
    private ImageView avatar;
    private ImageView imgCopy;
    private ImageView imgShare;
    private ImageView imgSms;
    private ImageView imgMail;
    private FloatingActionButton favorite;
    private CollapsingToolbarLayout collapsingToolbarLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_page);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            layoutId = Integer.parseInt(extras.getString("id"));
            pageName = extras.getString("name");
            assert pageName != null;
            if (pageName.equals("flower")) {
                id = MainActivity.flower.get(layoutId).getId();
                title = MainActivity.flower.get(layoutId).getTitle();
                content = MainActivity.flower.get(layoutId).getContent();
                more = MainActivity.flower.get(layoutId).getMore();
                imageAddress = MainActivity.flower.get(layoutId).getImgAddress();

            } else if (pageName.equals("tree")) {
                id = MainActivity.tree.get(layoutId).getId();
                title = MainActivity.tree.get(layoutId).getTitle();
                content = MainActivity.tree.get(layoutId).getContent();
                more = MainActivity.tree.get(layoutId).getMore();
                imageAddress = MainActivity.tree.get(layoutId).getImgAddress();
            } else if (pageName.equals("favorite")) {
                id = MainActivity.favorite.get(layoutId).getId();
                title = MainActivity.favorite.get(layoutId).getTitle();
                content = MainActivity.favorite.get(layoutId).getContent();
                more = MainActivity.favorite.get(layoutId).getMore();
                imageAddress = MainActivity.favorite.get(layoutId).getImgAddress();
            }


            Log.i("log","id: "+id);
            Log.i("log","title: "+title);
            Log.i("log","content: "+content);
            Log.i("log","more: "+more);
            Log.i("log","imaddress: "+imageAddress);
            contentDescription = findViewById(R.id.content_des);
            moreDescriptin=findViewById(R.id.more_des);
            avatar=findViewById(R.id.avetar);
            imgCopy=findViewById(R.id.img_copy);
            imgShare=findViewById(R.id.img_share);
            imgMail=findViewById(R.id.img_mail);
            imgSms=findViewById(R.id.img_sms);
            favorite=findViewById(R.id.favorite);
            collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar);
            collapsingToolbarLayout.setTitle(title);
            collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.white));

            contentDescription.setText(content);
            moreDescriptin.setText(more);
            int id2 = MainActivity.context.getResources().getIdentifier(imageAddress, "drawable", MainActivity.context.getPackageName());
       //     int imageId=MainActivity.context.getResources().getIdentifier(imageAddress,"drawable",MainActivity.context.getPackageName());
            Log.i("log","imageid: "+id2);

           avatar.setImageResource(id2);


        }


    }
}