package com.example.yashbohara.project;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.yashbohara.project.M1.dbhandler;
import static com.example.yashbohara.project.FilterClass.obj1;

public class CustomAdapter2 extends ArrayAdapter<String> {
       public static String a;
        public static String b;
        public static String c;
        public CustomAdapter2(Context context, ArrayList<String> list2) {
            super(context, R.layout.row2, list2);

        }

    public CustomAdapter2(Context context2,String s, String s1, String s2) {
        super(context2, R.layout.row2);
        a=s;
        b=s1;
        c=s2;
    }

    @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            View view=layoutInflater.inflate(R.layout.row2,parent,false);
            String singlelist2=getItem(position).toString();
            TextView textview=(TextView) view.findViewById(R.id.textView);
            TextView textview4=(TextView) view.findViewById(R.id.textView4);
            TextView textview5=(TextView) view.findViewById(R.id.textView5);
            TextView textview6=(TextView) view.findViewById(R.id.textView6);
            TextView textview2=(TextView) view.findViewById(R.id.textView2);
            TextView textview3=(TextView) view.findViewById(R.id.textView3);
            textview4.setText(singlelist2);
            textview.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"01"));
            textview5.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"02"));
            textview6.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"03"));
            textview3.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"04"));
            textview2.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"05"));
            return view;
        }
    }
