package com.example.yashbohara.project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter3 extends ArrayAdapter<String> {
    public CustomAdapter3(Context context, ArrayList<String> item) {
        super(context,R.layout.row3,item);
       }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.row3, parent, false);
        String singlelist = getItem(position).toString();
        TextView t=(TextView) view.findViewById(R.id.t12);
        t.setText(singlelist);
        return view;
    }
}