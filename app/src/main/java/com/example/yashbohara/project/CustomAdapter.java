package com.example.yashbohara.project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String>{

    public CustomAdapter(Context context, ArrayList<String> item) {
        super(context, R.layout.row,item);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View view=layoutInflater.inflate(R.layout.row,parent,false);
        String singlelist=getItem(position).toString();
        CheckBox c1=(CheckBox) view.findViewById(R.id.c1);
        c1.setText(singlelist);
        return view;
    }
}
