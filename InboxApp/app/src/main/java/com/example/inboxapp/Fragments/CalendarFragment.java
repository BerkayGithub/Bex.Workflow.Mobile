package com.example.inboxapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inboxapp.Adapters.MyAdapter;
import com.example.inboxapp.R;

public class CalendarFragment extends Fragment {

    String s1[], s2[], s3[];
    RecyclerView recyclerView;

    public CalendarFragment() {
        // Required empty public constructor
    }

    public static CalendarFragment newInstance(String param1, String param2) {
        CalendarFragment fragment = new CalendarFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        s1 = getResources().getStringArray(R.array.senders);
        s2 = getResources().getStringArray(R.array.subject);
        s3 = getResources().getStringArray(R.array.message);
        MyAdapter myAdapter = new MyAdapter(getContext(), s1, s2, s3);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
