package com.example.yashbohara.project;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
            final TextView textview=(TextView) view.findViewById(R.id.textView);
        final TextView textview4=(TextView) view.findViewById(R.id.textView4);
        final TextView textview5=(TextView) view.findViewById(R.id.textView5);
        final TextView textview6=(TextView) view.findViewById(R.id.textView6);
        final TextView textview2=(TextView) view.findViewById(R.id.textView2);
        final TextView textview3=(TextView) view.findViewById(R.id.textView3);
            textview4.setText(singlelist2);
            //textview.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"01"));
            //textview5.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"02"));
            //textview6.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"03"));
            //textview3.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"04"));
            //textview2.setText(dbhandler.Extract(b,c,a,singlelist2,b+a+"05"));
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=database.getReference("Student"+b+c+a);
        databaseReference.child(singlelist2).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String p=dataSnapshot.child(b+a+"01").getValue().toString();
                textview.setText(p);
                String q=dataSnapshot.child(b+a+"02").getValue().toString();
                textview5.setText(q);
                String r=dataSnapshot.child(b+a+"03").getValue().toString();
                textview6.setText(r);
                String m=dataSnapshot.child(b+a+"04").getValue().toString();
                textview3.setText(m);
                String n=dataSnapshot.child(b+a+"05").getValue().toString();
                textview2.setText(n);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });









        return view;
        }
    }
