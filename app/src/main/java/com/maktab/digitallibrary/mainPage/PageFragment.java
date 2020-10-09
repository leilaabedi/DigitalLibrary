package com.maktab.digitallibrary.mainPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maktab.digitallibrary.R;

public class PageFragment extends Fragment {
    private int mPage;
    public static final String ARG_PAGE = "ARG_PAGE";
    RecyclerView recyclerView;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        if (mPage == 3) {
            recyclerView = view.findViewById(R.id.my_recycler_view);
            AdapterFlower adapter = new AdapterFlower(MainActivity.context);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.context));
        }


        if (mPage == 2 ) {
            recyclerView = view.findViewById(R.id.my_recycler_view);
            AdapterTree adapter = new AdapterTree(MainActivity.context);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.context));
        }

        if (mPage == 1) {
            recyclerView = view.findViewById(R.id.my_recycler_view);
            AdapterFav adapter= new AdapterFav(MainActivity.context);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.context));
        }


        return view;
    }

}
