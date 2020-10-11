package com.maktab.digitallibrary.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.maktab.digitallibrary.R;
import com.maktab.digitallibrary.database.DatabaseAccess;
import com.maktab.digitallibrary.mainPage.MainActivity;

public class ActivitySearch extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterSearch adapter;
    EditText searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchItem=findViewById(R.id.searchitem);
        recyclerView=findViewById(R.id.my_recycler_view);
        adapter=new AdapterSearch(MainActivity.context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.context));

        searchItem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                searchSelect(s.toString());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void searchSelect(CharSequence charac){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        MainActivity.allItems.clear();
        MainActivity.allItems = databaseAccess.getSearch(charac);
        databaseAccess.close();



    }
}